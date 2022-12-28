public class Main {

    static boolean[][] grid = {
            { true, false, false, true },
            { false, true, true, false },
            { false, false, false, true },
            { false, true, true, true }
    };

    static int [][] right  = {
            { 1, 3, 3, 1 },
            { 2, 2, 3, 3 },
            { 2, 4, 6, 3 },
            { 1, 1, 3, 2 }
    };

    public static void main(String[] args) {
        NeighborCounter nc = new NeighborCounter(grid);
        System.out.println("Testing the 3rd Count method");
        for (int r=0; r<4; ++r)
            for (int c=0; c<4; ++c) {
                int n = nc.Count3(r,c);
                if (n != right[r][c])
                    System.out.println(r + "," + c + " is "
                        + n + " but should be " + right[r][c]
                    );
            }
    }

}