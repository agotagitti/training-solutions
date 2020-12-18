package week08d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathAlgorithmsTest {

    @Test
    public void testGreatestCommonDivisor() {
        MathAlgorithms mathAlgorithms = new MathAlgorithms();

        assertEquals(24, mathAlgorithms.greatestCommonDivider(48, 24));
        assertEquals(1, mathAlgorithms.greatestCommonDivider(13465498,5744983));
    }

}
