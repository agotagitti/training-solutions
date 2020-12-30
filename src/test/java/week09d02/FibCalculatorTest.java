package week09d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibCalculatorTest {

    @Test
    public void testSumEven() {
        FibCalculator fibCalculator = new FibCalculator();

        assertEquals(10, fibCalculator.sumEvens(8));
        assertEquals(60696, fibCalculator.sumEvens(190000));
    }

}
