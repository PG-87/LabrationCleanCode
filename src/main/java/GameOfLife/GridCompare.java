package GameOfLife;

import java.util.Arrays;

public class GridCompare {

    public static boolean compareCurrentWithFutureGrid(Grid current, Grid future) {
        return Arrays.deepEquals(current.getGrid(), future.getGrid());
    }
}
