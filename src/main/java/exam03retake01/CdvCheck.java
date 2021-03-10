package exam03retake01;

import java.util.ArrayList;
import java.util.List;

public class CdvCheck {


    public boolean check(String s) {
        if (s.length() != 10) {
            throw new IllegalArgumentException("Invalid parameter");
        }
        try {
            Long.parseLong(s);
        }
        catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Invalid parameter");
        }
        List<Integer> taxNumbers = new ArrayList<>();
        for (char actualChar : s.toCharArray()) {
            taxNumbers.add(Character.getNumericValue(actualChar));
        }
        int sumNineNumbers = 0;
        for (int i = 0; i < 9; i++) {
            sumNineNumbers += taxNumbers.get(i) * (i + 1);
        }
        return sumNineNumbers % 11 == taxNumbers.get(9);
    }
}
