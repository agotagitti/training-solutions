package week10d05;

import org.junit.jupiter.api.Test;
import schoolrecords.ClassRecords;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testFindMinSum() {
        int[] numbers = {1, 3, 5, 9, 7, 2, 75, -4};
        int[] numbers2 = {1, 3, 5, 7, 9};
        Calculator calculator = new Calculator();

        assertEquals(2, calculator.findMinSum(numbers));
        assertEquals(16, calculator.findMinSum(numbers2));
    }

    @Test
    void testFindMinSumWithException() {
        int[] numbers3 = {1, 2, 3};


        Exception ex = assertThrows(ArrayIndexOutOfBoundsException.class, () -> new Calculator().findMinSum(numbers3));
        assertEquals("Not enough elements!", ex.getMessage());
    }
}