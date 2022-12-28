import java.util.ArrayList;
import java.util.concurrent.*;

public class board {
    private cell g[][]; //grid of cells
    private int u; //number of update rounds
    private int r; //# of rows total
    private int c; //# of columns total
    private int m;
    private Semaphores ss;

    board(Boolean[][] live, int update, int row, int column)  {
        u = update;
        r = row;
        c = column;
        m = c * r;
        ss = new Semaphores();
        ss.start = new Semaphore(m);
        ss.phase1 = new Semaphore(m);
        ss.phase2 = new Semaphore(m);
        ss.finished = new Semaphore(m);
        ss.proceed = new Semaphore(m);
        g = new cell[r][c]; //initialize the 2D grid array
        for (int i = 0; i < r; i++) {
            for (int u = 0; u < c; u++) {
                g[i][u] = new cell(this, i, u, live[i][u]);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int u = 0; u < c; u++) {
                g[i][u].findNeighbors(); //technically this exposes internal workings of the cell class
            }
        }
    }

    public cell getCell(int row, int column) { return g[row][column]; }

    public int getRows() { return r; }

    public int getColumns() { return c; }

    public void play() throws InterruptedException{
        ArrayList<cellThread> threads = new ArrayList<>();
        ss.start.acquire(m); //grabs start before initializing threads to force them to wait
        // initializes the threads
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                threads.add(new cellThread(ss, this, i, j, u));
            }
        }
        for (cellThread t : threads) t.start();

        System.out.printf("doing %s rounds\n", u);
        for (int k = 1; k <= u; k++) {
            System.out.printf("starting round # %s of %d \n", k, u);
            //grabs these in the loop for efficency
            ss.proceed.acquire(m);
            ss.phase2.acquire(m);    

            //begins the first phase
            System.out.println("Top of the cycle");
            ss.start.release(m); //this releases the threads allowing them to begin running cell.survive()

            ss.phase1.acquire(m); //when all threads have released their phase1, meaning all survives are complete
            System.out.println("Phase 1 complete");

            //when phase 1 completes, moves to phase 2
            ss.phase2.release(m); //this releases the threads allowing them to begin running cell.update()
            ss.phase1.release(m); //no need to keep holding onto this
            ss.start.acquire(m); //setting up for the next cycle

            ss.finished.acquire(m); //when all threads have released their phase2, meaning all updates are complete
            System.out.println("Phase 2 complete");
            ss.finished.release(m);

            //with phase 2 completed, moves on to print
            print(); 
            ss.proceed.release(m);
        }
    }

    public void print() {
        for (int i = 0; i < r; i++) {
            for (int u = 0; u < c; u++) {
                if(g[i][u].alive()) System.out.print("X");
                else System.out.print(".");
            }
            System.out.println();
        }
        System.out.println();
    }
};
