package week05d02;

public class ChangeLetter {

    public static final String TOCHANGE = "aeiou";

    public String changeVowels(String string) {
        char actual;
        String result = "";
        for (int i = 0; i < string.length(); i++) {
                actual = string.toLowerCase().charAt(i);
                if (TOCHANGE.indexOf(actual) >= 0) {
                    result += "*";
                } else {
                    result += string.charAt(i);
                }

        }
        return result;
    }

}
