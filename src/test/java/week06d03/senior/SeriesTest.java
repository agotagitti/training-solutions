package week06d03.senior;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeriesTest {

    @Test
    void testCalculateSeriesType() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<Integer> numbers2 = List.of(5, 4, 3, 2, 1);
        List<Integer> numbers3 = List.of(1, 4, 2, 5, 3);
        Series series = new Series();
        assertEquals("Ascending numbers",series.calculateSeriesType(numbers));
        assertEquals("Descending numbers",series.calculateSeriesType(numbers2));
        assertEquals("Mixed numbers",series.calculateSeriesType(numbers3));

    }
}