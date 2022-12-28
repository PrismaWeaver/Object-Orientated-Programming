public class cell {
    private boolean a; //alive
    private boolean s; //survive
    private board b; //parent
    private int r; //row
    private int c; //column
    private cell n[] = new cell[8];
    private int nc;

    cell(board grid, int row, int column, boolean alive) {
        r = row;
        c = column;
        a = alive;
        b = grid;
        nc = 0; //keep track of actual neighbor count
    }

    public void findNeighbors() {
        int rLim = b.getRows(), cLim = b.getColumns();
        boolean rd, ru, cd, cu;
        rd = ru = cd = cu = false;
        if ((r - 1) >= 0) rd =true;
        if ((r + 1) < rLim) ru = true;
        if ((c - 1) >= 0) cd = true;
        if ((c + 1) < cLim) cu = true;
        if (cd) foundNeighbor(r, c - 1);
        if (cu) foundNeighbor(r, c + 1);
        if (rd) {
            foundNeighbor(r - 1, c);
            if (cd) foundNeighbor(r - 1, c - 1);
            if (cu) foundNeighbor(r - 1, c + 1);
        }
        if (ru) {
            foundNeighbor(r + 1, c);
            if (cd) foundNeighbor(r + 1, c - 1);
            if (cu) foundNeighbor(r + 1, c + 1);
        }
    }

    private void foundNeighbor(int row, int column) {n[nc++] = b.getCell(row, column);}

    public boolean alive() { return a;}

    public void survival() {
        int aliveCount = 0;
        for (int i = 0; i < nc; i++) {
            if (n[i].alive()) aliveCount++;
        }
        if (aliveCount >= 2 && aliveCount <= 3) s = true;
        else s = false;
    }

    public void update() {
        a = s;
    }
};
