package week07d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberListTest {

    @Test

    public void testIsIncreasing() {
        NumberList numberList = new NumberList();
        List<Integer> intList = Arrays.asList(1, 2, 3, 3, 3, 5);
        List<Integer> intList2 = Arrays.asList(1, 2, 3, 6, 3, 5);

        assertTrue(numberList.isIncreasing(intList));
        assertFalse(numberList.isIncreasing(intList2));
    }

}
