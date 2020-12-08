package week07d02;

public class DigitSum {

    public int sumOfDigits(int x) {
        String intToString = Integer.toString(x);
        int sumDigits = 0;
        for (int i = 0; i < intToString.length(); i++) {
            sumDigits += Integer.parseInt(Character.toString(intToString.charAt(i)));
        }
        return sumDigits;
    }

}
