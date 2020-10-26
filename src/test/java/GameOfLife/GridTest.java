package GameOfLife;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

    Grid grid;

    @BeforeEach
    void setup() {
        grid = new Grid();
    }

    @Test
    void checkGridForTwoDifferentCharacters() {
        IntStream stream = Arrays.stream(grid.getGrid()).flatMapToInt(Arrays::stream);
        assertEquals(2, stream.distinct().count());
    }

    @Test
    void checkIfGridIsOnlyFilledWithOnesAndZeroes() {
        int gridSize = grid.getGrid().length * grid.getGrid()[0].length;
        System.out.println(gridSize);
        IntStream stream = Arrays.stream(grid.getGrid())
                .flatMapToInt(Arrays::stream);
        int OnesAndZeroes = (int) stream.filter(n -> n == 0 || n == 1).count();
        assertEquals(gridSize, OnesAndZeroes);
    }

    @Test
    void checkIfIncomingGridIsTheSameAsCurrentAndReturnTrue() {
        int[][] testGrid = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        Grid futureGrid = new Grid(testGrid);

        assertThat(grid.compareGrids(futureGrid)).isTrue();
    }
}