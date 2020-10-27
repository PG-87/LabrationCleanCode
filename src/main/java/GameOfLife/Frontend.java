package GameOfLife;

public class Frontend {

    public void printGameBoard(Grid grid) {
        System.out.println("--------------------------------------------------------------------");
        //       System.out.println("--------------------------------------------------------------------");
        for (int column = 0; column < grid.getGrid().length; column++) {
            for (int row = 0; row < grid.getGrid().length; row++) {
                if (grid.getGrid()[column][row] == 0)
                    System.out.print("   ");
                else
                    System.out.print("|X|");
            }
            System.out.println();
        }
        System.out.println();
    }

}
