package GameOfLife;

public class GameOfLife {

    public Grid createNextGeneration(Grid grid) {

        Grid nextGeneration = new Grid(grid.size());

        for (int l = 1; l < grid.size() - 1; l++) {
            for (int m = 1; m < grid.size() - 1; m++) {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours += grid.getGrid()[l + i][m + j];

                aliveNeighbours -= grid.getGrid()[l][m];

                if ((grid.getGrid()[l][m] == 1) && (aliveNeighbours < 2))
                    nextGeneration.getGrid()[l][m] = 0;
                else if ((grid.getGrid()[l][m] == 1) && (aliveNeighbours > 3))
                    nextGeneration.getGrid()[l][m] = 0;
                else if ((grid.getGrid()[l][m] == 0) && (aliveNeighbours == 3))
                    nextGeneration.getGrid()[l][m] = 1;
                else
                    nextGeneration.getGrid()[l][m] = grid.getGrid()[l][m];
            }
        }
        return nextGeneration;
    }
}
