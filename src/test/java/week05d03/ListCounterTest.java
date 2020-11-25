package week05d03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class ListCounterTest {

    @Test
    public void testListCounter() {

        List<String> words = new ArrayList<>();
        words.add("alma");
        words.add("körte");
        words.add("ALMA");
        words.add("123");

        assertEquals(2, new ListCounter().listCounter(words));

    }

    @Test
    public void testListCounterNoA() {

        List<String> words = new ArrayList<>();
        words.add("narancs");
        words.add("körte");
        words.add("SZILVA");
        words.add("123");

        assertEquals(0, new ListCounter().listCounter(words));

    }
}
