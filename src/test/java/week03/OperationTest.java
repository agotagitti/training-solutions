package week03;

import org.junit.jupiter.api.Test;
import week03d05.Operation;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationTest {

    @Test
    public void testGetResult() {
        Operation operation = new Operation("10+20");

        assertEquals(30, operation.getResult());
    }
}
