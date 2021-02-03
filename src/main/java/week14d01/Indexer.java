package week14d01;

import java.util.*;

public class Indexer {

    public Map<Character, List<String>> index(List<String> names) {
        Map<Character, List<String>> result = new HashMap<>();
        for (String actual: names) {
            Character key = actual.charAt(0);
            if (result.containsKey(key)) {
                result.get(key).add(actual);
            } else {
                result.put(key, new ArrayList<>(Arrays.asList(actual)));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Indexer indexer = new Indexer();
        System.out.println(new Indexer().index(Arrays.asList("Odon","Lujza","Abraham", "Olga", "Magdolna")));
    }

}
