package exam03;

import java.io.BufferedReader;
import java.io.IOException;

public class Histogram {


    public String createHistogram(BufferedReader reader) throws IOException {
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            int number = Integer.parseInt(line);
            for (int i = 0; i < number; i++) {
                result.append("*");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
