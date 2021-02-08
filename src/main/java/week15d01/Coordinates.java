package week15d01;

import java.util.HashMap;
import java.util.Map;

public class Coordinates {

    public Map.Entry<Integer, Integer> getMaxPlace(Map<Integer, Integer> data) {
        Map.Entry<Integer, Integer> result = null;
        for (Map.Entry<Integer, Integer> actual: data.entrySet()) {
            if (result == null || (actual.getValue() > result.getValue())) {
                result = actual;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Coordinates coordinates = new Coordinates();
        Map<Integer, Integer> data = new HashMap<>();
        data.put(1, 2);
        data.put(5, 3);
        data.put(3, 5);
        data.put(4, 7);
        data.put(2, 9);
        System.out.println(coordinates.getMaxPlace(data));
    }

}
