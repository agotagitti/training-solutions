package week05d02;

public class ChangeLetter {

    private String toChange = "aeiou";

    public String changeVowels(String string) {
        char actual;
        String result = "";
        try {
            for (int i = 0; i < string.length(); i++) {
                actual = string.toLowerCase().charAt(i);
                if (toChange.indexOf(actual) >= 0) {
                    result += "*";
                } else {
                    result += string.charAt(i);
                }
            }
        } catch (NullPointerException npe) {
            System.out.println("String cannot be null!");
        }
        return result;
    }

}
