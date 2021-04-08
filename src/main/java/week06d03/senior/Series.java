package week06d03.senior;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Series {

    public String calculateSeriesType(List<Integer> numbers) {
        if (numbers.size() <= 1) {
            throw new IllegalArgumentException("Invalid number list");
        }
        List<Integer> tempNumbers = new ArrayList<>(numbers);
        Collections.sort(tempNumbers);
        if (tempNumbers.equals(numbers)) {
            return "Ascending numbers";
        }
        Collections.reverse(tempNumbers);
        if (tempNumbers.equals(numbers)) {
            return "Descending numbers";
        }
        return "Mixed numbers";
    }

}
