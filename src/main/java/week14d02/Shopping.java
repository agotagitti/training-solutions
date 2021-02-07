package week14d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Shopping {

    private Map<String, List<String>> shoppingList = new LinkedHashMap<>();

    public void readFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)){
            String line;
            while ((line =br.readLine()) != null) {
                String[] parts = line.split(" ");
                String[] items = parts[1].split(",");
                List<String> itemList = new ArrayList<>();
                for (String actual: items) {
                    itemList.add(actual);
                }
                shoppingList.put(parts[0],itemList);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    public List<String> getItemsById (String id) {
        List<String> result = new ArrayList<>(shoppingList.get(id));
        Collections.sort(result);
        return result;
    }
    //Objektumoknál Comparable-t kellene használni, ha név alapján akarom rendezni

    public List<String> getReverseItemsById (String id) {
        List<String> result = getItemsById(id);
        Collections.reverse(result);
        return result;
    }

    public int getSaleNumberByItem(String item) {
        int result = 0;
        Collection<List<String>> values = shoppingList.values();
        for(List<String> actual: values) {
            if (actual.contains(item)) {
                result++;
            }
        }
        return result;
    }

    public int getNumberOfItemsById(String id) {
        return shoppingList.get(id).size();
    }

    public Map<String, Integer> getStatistics() {
        Map<String, Integer> result = new HashMap<>();
        int count = 0;
        for(List<String> actual: shoppingList.values()) {
            for(String actualString: actual) {
                if (!result.containsKey(actualString)) {
                    count = getSaleNumberByItem(actualString);
                    result.put(actualString, count);
                }
            }
        }
        return result;
    }



//    public static void main(String[] args) {
//        Shopping shopping = new Shopping();
//        shopping.readFile(Path.of("src/main/resources/shopping.txt"));
//        System.out.println(shopping.getItemsById("B4302"));
//        System.out.println(shopping.getReverseItemsById("B4302"));
//        System.out.println(shopping.getSaleNumberByItem("tomato"));
//        System.out.println(shopping.getNumberOfItemsById("B4302"));
//        Map<String, Integer> resultMap = shopping.getStatistics();
//        System.out.println(resultMap);
//    }

}
