package GameOfLife;

public class StartGame {

    public static void main(String[] args) {

        Grid grid = new Grid();
        GameOfLife gameOfLife = new GameOfLife();


        var futureGrid = gameOfLife.createNextGeneration(grid);

    }
}

