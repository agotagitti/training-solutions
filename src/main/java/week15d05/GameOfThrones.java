package week15d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class GameOfThrones {

    private Map<String, Integer> processFile() {
        Map<String, Integer> result = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(GameOfThrones.class.getResourceAsStream("/battles.csv")))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineData = line.split(",");
                for (int i = 5; i <= 12; i++) {
                    processHouse(result, lineData[i]);
                }
            }
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return result;
    }

    public String getHouseWithMostBattles() {
        Map<String, Integer> houses = processFile();
        Map.Entry<String, Integer> houseWithMostBattles = null;
        for (Map.Entry<String,Integer> actual : houses.entrySet()) {
            if (houseWithMostBattles == null || houseWithMostBattles.getValue() < actual.getValue()) {
                houseWithMostBattles = actual;
            }
        }
        return houseWithMostBattles.getKey();
    }

    private void processHouse(Map<String, Integer> result, String house) {
        if (!house.isEmpty()) {
            if (!result.containsKey(house)) {
                result.put(house, 0);
            }
            result.put(house, result.get(house) + 1);
        }
    }

    public static void main(String[] args) {
        GameOfThrones gameOfThrones = new GameOfThrones();

        System.out.println(gameOfThrones.getHouseWithMostBattles());
    }

}
