import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import torpedo.Coordinate;

class CoordinateTest {
    @Test
    void testConstructor() {
        Coordinate actualCoordinate = new Coordinate(1, 1);

        assertEquals(1, actualCoordinate.getX());
        assertEquals(1, actualCoordinate.getY());
    }
}