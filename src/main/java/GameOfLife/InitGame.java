package GameOfLife;

public class InitGame {

    public static void main(String[] args) {
        InitGame initGame = new InitGame();
        initGame.start(new GameOfLife(), initGame.createGrid());
    }

    private Grid createGrid() {
        return new Grid();
    }

    private void start(GameOfLife gameOfLife, Grid grid){
        Grid future = new Grid(10);
        PrintGrid.printGameBoard(grid);
        while(gridsAreDifferent(grid, future)){
            future = gameOfLife.createNextGeneration(grid);
            PrintGrid.printGameBoard(future);
            if (gridsAreDifferent(grid, future)) {
                grid = future;
                future = new Grid(10);
            }
        }
    }

    private boolean gridsAreDifferent(Grid grid, Grid futureGrid) {
        return !grid.compareGrids(futureGrid);
    }
}