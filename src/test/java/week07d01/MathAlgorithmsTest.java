package week07d01;

import immutable.satellite.CelestialCoordinates;
import immutable.satellite.Satellite;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathAlgorithmsTest {

    @Test
    public void testIsPrime() {

        assertEquals(false, MathAlgorithms.isPrime(1));
        assertEquals(true, MathAlgorithms.isPrime(2));
        assertEquals(false, MathAlgorithms.isPrime(9));
        assertEquals(true, MathAlgorithms.isPrime(13));
    }

}
