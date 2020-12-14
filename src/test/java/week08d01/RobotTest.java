package week08d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RobotTest {

    @Test
    public void testMove() {
        Robot robot = new Robot(0, 0);

        assertEquals("New position: 3, -3",robot.move("FFLLLLLBBBBJJJJJJJ").toString());
        assertEquals(3, robot.getX());
        assertEquals(-3, robot.getY());
    }

    public void testMoveWithWrongString() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Robot(0,0));
        assertEquals("Character cannot found!", ex.getMessage());
    }

}
