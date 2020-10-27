package GameOfLife;

import java.util.Arrays;

public class Grid {

    private final int[][] grid;

    public Grid() {
        this.grid = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
    }

    public Grid(int gridSize){
        this.grid = new int[gridSize][gridSize];
    }

    public Grid(int[][] grid){
        this.grid = grid;
    }

    public int[][] getGrid() {
        return grid;
    }

    public boolean compareGrids(Grid future) {
        return Arrays.deepEquals(grid, future.getGrid());
    }

    public int size() {
        return grid.length;
    }

    public static boolean compareTwoGrids(Grid a, Grid b) {
        return Arrays.deepEquals(a.getGrid(), b.getGrid());
    }
}

