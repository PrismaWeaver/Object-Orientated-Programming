public class cellThread extends Thread {
    Semaphores ss;
    int r;
    int c;
    cell cell;
    int u;

    public cellThread(Semaphores ss, board grid, int row, int column, int update) throws InterruptedException {
        r = row;
        c = column;
        u = update;
        this.cell = grid.getCell(row, column);
        this.ss = ss;
    }

    @Override
    public void run() {
        for (int i = 0; i < u; i++) {
            try {cycle();} catch (InterruptedException e) { e.printStackTrace(); }
            try {ss.proceed.acquire();} catch (InterruptedException e) { e.printStackTrace(); }
            ss.proceed.release();
        }
    }

    public void cycle() throws InterruptedException {
        ss.phase1.acquire(); //this shows they are currently preparing to start survival phase
        ss.finished.acquire(); //this is to let play() know when this thread is done
        ss.start.acquire(); //will wait until play() lets them go

        ss.start.release(); //no need to hang onto this
        cell.survival(); //calls the survival method of its cell
        System.out.printf("   Cell at row %s column %d finished survival\n", r, c);
        ss.phase1.release(); //signals phase 1 is complete

        ss.phase2.acquire(); //waits to start phase 2 until play() lets them
        cell.update(); //calls the update method of its cell
        System.out.printf("   Cell at row %s column %d finished update\n", r, c);
        ss.phase2.release(); //signals phase 2 is complete

        ss.finished.release(); //singals that the cycle is done
    }
}
