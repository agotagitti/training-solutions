package controlselection.accents;

public class WithoutAccents {

    private String vowelsWithAccent = "áÁéÉíÍóÓöÖőŐúÚüÜűŰ";
    private String vowelsWithoutAccent = "aAeEiIoOoOoOuUuUuU";


    public char convertToCharWithoutAccents(char character) {
        char resultChar;
        if (isWithAccent(character)) {
            resultChar = vowelsWithoutAccent.charAt(vowelsWithAccent.indexOf(character));
        } else {
            resultChar = character;
        }
        return resultChar;
    }

    private boolean isWithAccent(char character) {
        return vowelsWithAccent.indexOf(character) >= 0;
    }
}
