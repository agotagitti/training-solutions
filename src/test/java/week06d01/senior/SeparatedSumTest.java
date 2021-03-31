package week06d01.senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeparatedSumTest {

    @Test
    void testSum() {
        SeparatedSum separatedSum = new SeparatedSum();
        String s1 = "-1,1";
        String s2 = "2,3;6,5;11";
        String s3 = "4,5;-0,5;-2,9";
        String text = "String value is ";

        assertEquals(text + "-1.1", separatedSum.sum(s1));
        assertEquals(text + "0.0 + 19.8", separatedSum.sum(s2));
        assertEquals(text + "-3.4 + 4.5", separatedSum.sum(s3));

    }
}