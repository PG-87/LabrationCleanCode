package GameOfLife;

public class GameOfLife {

    private Grid currentGrid;
    private Grid futureGrid;

    public Grid createNextGeneration(Grid grid) {
        this.currentGrid = grid;
        futureGrid =new Grid(grid.size());

        for (int row = 1; row < currentGrid.getGrid().length - 1; row++)
            for (int column = 1; column < currentGrid.getGrid().length - 1; column++) {
                int aliveNeighbours = getAliveNeighbours(row, column);
                aliveNeighbours -= currentGrid.getGrid()[row][column];
                futureGrid.getGrid()[row][column] = setFutureCell(aliveNeighbours, currentGrid.getGrid()[row][column]);
            }
        return futureGrid;
    }

    private int getAliveNeighbours(int row, int column) {
        int aliveNeighbours = 0;
        for (int i = -1; i <= 1; i++)
            for (int j = -1; j <= 1; j++)
                aliveNeighbours += currentGrid.getGrid()[row + i][column + j];
        return aliveNeighbours;
    }

    private int setFutureCell(int aliveNeighbours, int cell) {
        final byte ALIVE = 1;
        final byte DEAD = 0;
        boolean isCellAlive = (cell == 1);
        boolean cellLivesNextGen = isCellAliveNextGen(isCellAlive, aliveNeighbours);
        return cellLivesNextGen ? ALIVE : DEAD;
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