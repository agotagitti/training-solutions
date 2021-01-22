package week12d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberStatTest {

    @Test
    void uniqueNumber() {

        NumberStat numberStat = new NumberStat();
        List<Integer> numbers = Arrays.asList(1,1,5,3,4,5,6,5,1,6,5,4);

        assertEquals(3, numberStat.uniqueNumber(numbers));
    }


    @Test
    void uniqueNumberMinus() {

        NumberStat numberStat = new NumberStat();
        List<Integer> numbers = Arrays.asList(1,1,5,3,4,-5,6,5,1,6,5,4);

        assertEquals(-5, numberStat.uniqueNumber(numbers));
    }
}