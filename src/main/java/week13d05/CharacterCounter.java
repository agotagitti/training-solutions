package week13d05;

import java.util.HashSet;
import java.util.Set;

public class CharacterCounter {

    public int getCharacterNumber(String word) {
        char[] wordToChar = word.toLowerCase().toCharArray();
        Set<Character> charCollection = new HashSet<>();
        for (char actual: wordToChar) {
            if (isEnglishChar(actual)) {
                charCollection.add(actual);
            }
        }
        return charCollection.size();
    }

    private boolean isEnglishChar(char c) {
        return c >= 'a' && 'z' >= c;
    }

    public static void main(String[] args) {
        CharacterCounter cc = new CharacterCounter();
        System.out.println(cc.getCharacterNumber("...abcdefg HIJKLMN 123456_*"));
    }

}
