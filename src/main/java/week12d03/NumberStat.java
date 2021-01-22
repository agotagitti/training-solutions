package week12d03;

import java.util.Collections;
import java.util.List;

public class NumberStat {

    public int uniqueNumber(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("List too short");
        }
        Collections.sort(numbers);
        int counter = 0;
        do {
            if ((counter == 0 || numbers.get(counter - 1).intValue() != numbers.get(counter).intValue())
            && (counter == numbers.size() - 1 || numbers.get(counter + 1).intValue() != numbers.get(counter).intValue())) {
                return numbers.get(counter);
            }
            counter++;
        } while (counter <= numbers.size());

        throw new IllegalArgumentException("No unique number on the list");
    }

}
