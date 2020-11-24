package week05d02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChangeLetterTest {

    @Test
    public void testChangeLetter() {

        ChangeLetter changeLetter = new ChangeLetter();

        assertEquals("kört*", changeLetter.changeVowels("körte"));
        assertEquals("*lm*", changeLetter.changeVowels("alma"));
        assertEquals("BÖLÖMB*K*", changeLetter.changeVowels("BÖLÖMBIKA"));
        assertEquals("", changeLetter.changeVowels(""));

    }

}