package week07d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DigitSumTest {

    @Test
    public void testSumOfDigits() {
        DigitSum digitSum = new DigitSum();

        assertEquals(6, digitSum.sumOfDigits(123));
        assertEquals(10, digitSum.sumOfDigits(10203040));
    }

}
