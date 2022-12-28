import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UnitTest {
    
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
    
    @Test 
    public void CountCorners() {
        NeighborCounter nc = new NeighborCounter(grid);
        assertEquals(right[0][0], nc.Count(0,0));
        assertEquals(right[0][3], nc.Count(0,3));
        assertEquals(right[3][3], nc.Count(3,3));
        assertEquals(right[3][0], nc.Count(3,0));
    }

    @Test
    public void CountEdges() {
        NeighborCounter nc = new NeighborCounter(grid);
        assertEquals(right[1][0], nc.Count(1,0));
        assertEquals(right[2][0], nc.Count(2,0));
        assertEquals(right[0][1], nc.Count(0,1));
        assertEquals(right[0][2], nc.Count(0,2));
        assertEquals(right[3][1], nc.Count(3,1));
        assertEquals(right[3][2], nc.Count(3,2));
        assertEquals(right[1][3], nc.Count(1,3));
        assertEquals(right[2][3], nc.Count(2,3));
    }

    @Test
    public void CountCenter() {
        NeighborCounter nc = new NeighborCounter(grid);
        assertEquals(right[1][1], nc.Count(1,1));
        assertEquals(right[1][2], nc.Count(1,2));
        assertEquals(right[2][1], nc.Count(2,1));
        assertEquals(right[2][2], nc.Count(2,2));
    }

    @Test 
    public void Count2Corners() {
        NeighborCounter nc = new NeighborCounter(grid);
        assertEquals(right[0][0], nc.Count2(0,0));
        assertEquals(right[0][3], nc.Count2(0,3));
        assertEquals(right[3][3], nc.Count2(3,3));
        assertEquals(right[3][0], nc.Count2(3,0));
    }

    @Test
    public void Count2Edges() {
        NeighborCounter nc = new NeighborCounter(grid);
        assertEquals(right[1][0], nc.Count2(1,0));
        assertEquals(right[2][0], nc.Count2(2,0));
        assertEquals(right[0][1], nc.Count2(0,1));
        assertEquals(right[0][2], nc.Count2(0,2));
        assertEquals(right[3][1], nc.Count2(3,1));
        assertEquals(right[3][2], nc.Count2(3,2));
        assertEquals(right[1][3], nc.Count2(1,3));
        assertEquals(right[2][3], nc.Count2(2,3));
    }

    @Test
    public void Count2Center() {
        NeighborCounter nc = new NeighborCounter(grid);
        assertEquals(right[1][1], nc.Count2(1,1));
        assertEquals(right[1][2], nc.Count2(1,2));
        assertEquals(right[2][1], nc.Count2(2,1));
        assertEquals(right[2][2], nc.Count2(2,2));
    }

    @Test 
    public void Count3Corners() {
        NeighborCounter nc = new NeighborCounter(grid);
        assertEquals(right[0][0], nc.Count3(0,0));
        assertEquals(right[0][3], nc.Count3(0,3));
        assertEquals(right[3][3], nc.Count3(3,3));
        assertEquals(right[3][0], nc.Count3(3,0));
    }

    @Test
    public void Count3Edges() {
        NeighborCounter nc = new NeighborCounter(grid);
        assertEquals(right[1][0], nc.Count3(1,0));
        assertEquals(right[2][0], nc.Count3(2,0));
        assertEquals(right[0][1], nc.Count3(0,1));
        assertEquals(right[0][2], nc.Count3(0,2));
        assertEquals(right[3][1], nc.Count3(3,1));
        assertEquals(right[3][2], nc.Count3(3,2));
        assertEquals(right[1][3], nc.Count3(1,3));
        assertEquals(right[2][3], nc.Count3(2,3));
    }

    @Test
    public void Count3Center() {
        NeighborCounter nc = new NeighborCounter(grid);
        assertEquals(right[1][1], nc.Count3(1,1));
        assertEquals(right[1][2], nc.Count3(1,2));
        assertEquals(right[2][1], nc.Count3(2,1));
        assertEquals(right[2][2], nc.Count3(2,2));
    }
}