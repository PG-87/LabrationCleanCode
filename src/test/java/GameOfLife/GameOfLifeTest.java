package GameOfLife;

import GameOfLife.GameOfLife;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOfLifeTest {

    GameOfLife gameOfLife;
    Grid grid;

    @BeforeEach
    void setup(){
        grid = new Grid();
        gameOfLife = new GameOfLife();
    }

    @Test
    void checkIfThereIsAliveCellsInGrid(){
        int sum = Arrays.stream(grid.getGrid()).flatMapToInt(Arrays::stream).sum();
        assertEquals(6, sum);
    }

    @Test
    void runOneGenerationAndReturnNextGenerationGrid(){
        Grid currentGrid = gameOfLife.createNextGeneration(grid);

        int[][] expectedFutureGrid = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        assertThat(expectedFutureGrid).isDeepEqualTo(currentGrid.getGrid());
    }

    @Test
    void killLivingCellInCornerAndReturnCellAsDead(){

        int[][] cornerGrid = new int[][]{
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
        };
        Grid cornerCellGrid = new Grid(cornerGrid);

        Grid afterOneRunGrid = gameOfLife.createNextGeneration(cornerCellGrid);
        int allShouldBeDead = Arrays.stream(afterOneRunGrid.getGrid())
                .flatMapToInt(Arrays::stream)
                .sum();
        assertEquals(0, allShouldBeDead);
    }

//    @Test
//    void checkHowManyNeighboursFirstCellInGridHasAndReturnSumOfNeighbours(){
//        int aliveNeighbors = gameOfLife.getNeighbours
//
//        assertEquals(1, aliveNeighbors);
//    }
}