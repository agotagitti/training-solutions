package week06d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordEraserTest {

    @Test
    public void testEraseWord() {
        WordEraser wordEraser = new WordEraser();

        assertEquals("birsalma körte NARANCS", wordEraser.eraseWord("alma birsalma körte NARANCS ALMA", "alma"));
    }
}
