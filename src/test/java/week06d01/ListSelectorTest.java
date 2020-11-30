package week06d01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListSelectorTest {

    @Test
    public void testEvenOrOdd() {
        ListSelector listSelector = new ListSelector();
        List<String> text = new ArrayList<>();
        text.add("alma");
        text.add("körte");
        text.add("narancs");
        text.add("banán");
        text.add("szilva");

        assertEquals("[alma, narancs, szilva]", listSelector.evenOrOdd(text));
    }

    @Test
    public void testEvenOrOddWithEmptyString() {
        ListSelector listSelector = new ListSelector();
        List<String> text = new ArrayList<>();

        assertEquals("", listSelector.evenOrOdd(text));
    }

    @Test
    public void testEvenOrOddWithNull() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> new ListSelector().evenOrOdd(null));
        assertEquals("List cannot be empty!", ex.getMessage());
    }
}
