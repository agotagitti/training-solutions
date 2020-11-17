package stringbuilder;

public class PalindromeValidator {

    public boolean isPalindrome(String word) {
        boolean palindrome = false;
        if (word == null) {
            throw new IllegalArgumentException("Text must not be null!");
        }
        StringBuilder sb = new StringBuilder(word.toLowerCase().trim());
        StringBuilder sbReverse = new StringBuilder(word.toLowerCase().trim()).reverse();
        if (sb.toString().equals(sbReverse.toString())) {
            palindrome = true;
        }
        return palindrome;
    }
}
