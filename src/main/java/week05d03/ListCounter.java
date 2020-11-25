package week05d03;

import java.util.List;

public class ListCounter {

    public int listCounter(List<String> words) {
        int counter = 0;
        for (String actual: words) {
            if (actual.toLowerCase().startsWith("a")) {
                counter++;
            }
        }
        return counter;
    }

}
