import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

    Grid grid;

    @BeforeEach
            void setup(){
        grid = new Grid();
    }

    @Test
    void createNewGridAndCheckForTwoDifferentCharacters(){
        IntStream stream = Arrays.stream(grid.getGrid()).flatMapToInt(Arrays::stream);
        assertEquals(2, stream.distinct().count());
    }
}
