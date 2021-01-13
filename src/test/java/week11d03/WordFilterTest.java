package week11d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordFilterTest {

    @Test
    void wordsWithChar() {
        WordFilter wordFilter = new WordFilter();
        List<String> wordList = Arrays.asList("alma", "körte", "szilva", "barack", "hurma");

        assertEquals(4, wordFilter.wordsWithChar(wordList, 'a').size());
        assertEquals(1, wordFilter.wordsWithChar(wordList, 'Ö').size());

    }
}