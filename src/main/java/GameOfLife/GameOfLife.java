package GameOfLife;

public class GameOfLife {

    public Grid createNextGeneration(Grid grid) {
        Grid futureGrid = new Grid(grid.getGrid().length);
        for (int row = 1; row < grid.getGrid().length - 1; row++)
            for (int column = 1; column < grid.getGrid().length - 1; column++) {
                int aliveNeighbours = getAliveNeighbours(grid, row, column);
                var currentCell = grid.getGrid()[row][column];
                aliveNeighbours -= currentCell;
                setFutureCell(futureGrid, currentCell, row, column, aliveNeighbours);
            }
        return futureGrid;
    }

    private int getAliveNeighbours(Grid grid, int row, int column) {
        int aliveNeighbours = 0;
        for (int i = -1; i <= 1; i++)
            for (int j = -1; j <= 1; j++)
                aliveNeighbours += grid.getGrid()[row + i][column + j];
        return aliveNeighbours;
    }

    private void setFutureCell(Grid futureGrid, int currentCell, int row, int column, int aliveNeighbours) {
        final byte ALIVE = 1;
        final byte DEAD = 0;
        boolean isCellAlive = (currentCell == 1);
        boolean cellLivesNextGen = isCellAliveNextGen(isCellAlive, aliveNeighbours);
        futureGrid.getGrid()[row][column] = cellLivesNextGen ? ALIVE : DEAD;
    }


    private boolean isCellAliveNextGen(boolean isAlive, int aliveNeighbors) {
        return isAlive ? willLivingCellSurvive(aliveNeighbors) : isCellBorn(aliveNeighbors);
    }

    private boolean willLivingCellSurvive(int aliveNeighbors) {
        return aliveNeighbors == 2 || aliveNeighbors == 3;
    }

    private boolean isCellBorn(int aliveNeighbors) {
        return aliveNeighbors == 3;
    }


}