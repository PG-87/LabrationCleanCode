package GameOfLife;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


public class CellTest {

    Cell cell;

    @Test
    void setCellToAliveAndReturnTrue(){
        cell = new Cell();
        cell.setAlive(true);
        assertThat(cell.isAlive()).isTrue();

    }
}