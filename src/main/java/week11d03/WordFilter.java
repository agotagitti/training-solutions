package week11d03;

import java.util.ArrayList;
import java.util.List;

public class WordFilter {

    public List<String> wordsWithChar(List<String> words, char c) {
        List<String> containsChar = new ArrayList<>();
        for (String actual: words) {
            if (actual.toUpperCase().contains(Character.toString(c).toUpperCase())) {
                containsChar.add(actual);
            }
        }
        return containsChar;
    }

}
