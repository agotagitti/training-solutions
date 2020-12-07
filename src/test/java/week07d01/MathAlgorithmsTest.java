package week07d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MathAlgorithmsTest {

    @Test
    public void testIsPrime() {

        assertFalse(MathAlgorithms.isPrime(1));
        assertTrue(MathAlgorithms.isPrime(2));
        assertFalse(MathAlgorithms.isPrime(9));
        assertTrue(MathAlgorithms.isPrime(13));
    }

}
