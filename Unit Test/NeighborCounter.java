public class NeighborCounter {
    boolean[][] cells;
    int rows = 0;
    int cols = 0;
    public NeighborCounter(boolean[][] cells) {
        this.cells = cells;
        rows = cells.length;
        cols = cells[0].length;
    }

    public int Count(int row, int col) {
        int n = 0;
        n += live(row-1, col-1);
        n += live(row-1, col);
        n += live(row-1, col+1);
        n += live(row, col+1);
        n += live(row+1, col+1);
        n += live(row+1, col);
        n += live(row+1, col-1);
        n += live(row, col-1);
        return n;
    }


    public int Count2(int row, int col) {
        int n = 0;
        n += live(row+1, col-1);
        n += live(row+1, col);
        n += live(row+1, col+1);
        n += live(row, col+1);
        n += live(row+1, col+1);
        n += live(row+1, col);
        n += live(row+1, col-1);
        n += live(row, col-1);
        return n;
    }

    public int Count3(int row, int col) {
        int n = 0;
        n += live2(row-1, col-1);
        n += live2(row-1, col);
        n += live2(row-1, col+1);
        n += live2(row, col+1);
        n += live2(row+1, col+1);
        n += live2(row+1, col);
        n += live2(row+1, col-1);
        n += live2(row, col-1);
        return n;
    }

    private int live(int r, int c) {
        if (r < 0) return 0;
        if (c < 0) return 0;
        if (r >= rows) return 0;
        if (c >= cols) return 0;
        return (cells[r][c]) ? 1 : 0;
    }

    private int live2(int r, int c) {
        if (r < 0) r += rows;
        if (c < 0) c += cols;
        if (r >= rows) r -= rows;
        if (c >= cols) c -= cols;
        return (cells[r][c]) ? 1 : 0;
    }
}