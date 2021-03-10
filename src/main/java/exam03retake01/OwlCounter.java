package exam03retake01;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OwlCounter {

    private Map<String, Integer> numberOfOwls = new HashMap<>();

    public void readFromFile(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] lineData = line.split("=");
            int owlNumberData = Integer.parseInt(lineData[1]);
            numberOfOwls.put(lineData[0], owlNumberData);
        }
    }


    public int getNumberOfOwls(String s) {
        int owls = 0;
        for (Map.Entry<String, Integer> actualEntry : numberOfOwls.entrySet()) {
            if (actualEntry.getKey().equals(s)) {
                owls = (int) actualEntry.getValue();
            }
        }
        if (owls == 0) {
            throw new IllegalArgumentException("Invalid key");
        }
        return owls;
    }
}
