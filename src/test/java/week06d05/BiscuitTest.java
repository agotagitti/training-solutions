package week06d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BiscuitTest {

    @Test
    public void testOf() {
        Biscuit b1 = Biscuit.of(BiscuitType.BORDER, 100);
        Biscuit b2 = Biscuit.of(BiscuitType.WALKERS, 200);

        assertEquals(BiscuitType.BORDER, b1.getType());
        assertEquals(200, b2.getGramAmount());

    }

    @Test
    public void testPrintBiscuit() {
        Biscuit b3 = Biscuit.of(BiscuitType.PILOTA, 150);

        assertEquals("Biscuit: PILOTA, 150 grams", b3.toString());
    }

}
