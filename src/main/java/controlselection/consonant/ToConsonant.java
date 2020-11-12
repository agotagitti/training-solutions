package controlselection.consonant;

public class ToConsonant {

    private String letters = "abcdefghijklmnopqrstuvwxyz";
    private String vowels = "aeiou";

    public char convertToConsonant(char character) {
        char resultChar;
        if (isVowel(character)) {
            resultChar = letters.charAt(letters.indexOf(character) + 1);
            } else {
            resultChar = character;
        }
        return resultChar;
    }

    private boolean isVowel(char character) {
         return vowels.indexOf(character) >= 0;
    }
}
