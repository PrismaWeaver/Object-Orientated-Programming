public class board {
    private cell g[][]; //grid of cells
    private int u; //number of update rounds
    private int r; //# of rows total
    private int c; //# of columns total

    board(Boolean[][] live, int update, int row, int column)  {
        u = update;
        r = row;
        c = column;
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

    public void play() {
        for (int i = 0; i < u; i++) {
            calculate();
            update();
            print();
        }
    }

    private void calculate() {
        for (int i = 0; i < r; i++) {
            for (int u = 0; u < c; u++) {
                g[i][u].survival(); //thread initialization here
            }
        }
    }

    private void update() {
        for (int i = 0; i < r; i++) {
            for (int u = 0; u < c; u++) {
                g[i][u].update();
            }
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
