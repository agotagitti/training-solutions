package week08d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RobotTest {

    @Test
    public void testMoveRobot() {
        Robot robot = new Robot(0, 0);

        assertEquals("New position: 3, -3",robot.move("FFLLLLLBBBBJJJJJJJ").toString());
        assertEquals(3, robot.getX());
        assertEquals(-3, robot.getY());
    }

    @Test
    public void testMoveRobot2() {
        Robot2 robot2 = new Robot2(0, 0);

        assertEquals("New position: 3, -3",robot2.move("FFLLLLLBBBBJJJJJJJ").toString());
        assertEquals(3, robot2.getX());
        assertEquals(-3, robot2.getY());
    }

    @Test
    public void testMoveWithWrongString() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Robot(0,0).move("A"));
        assertEquals("Invalid direction!", ex.getMessage());
    }

}
