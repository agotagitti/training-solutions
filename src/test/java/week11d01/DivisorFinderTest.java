package week11d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisorFinderTest {

    @Test
    void findDivisor() {

        DivisorFinder df = new DivisorFinder();
        assertEquals(1, df.findDivisor(425));
        assertEquals(0, df.findDivisor(29));
        assertEquals(3, df.findDivisor(649789105));


    }
}