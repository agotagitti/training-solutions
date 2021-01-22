package week12d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Index {

    public int coronaCounter() {
        Path path = Path.of("index.html");
        int counter = 0;
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("koronavírus")) {
                    counter++;
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }
        return counter;
    }

    public static void main(String[] args) {
        Index index = new Index();
        System.out.println(index.coronaCounter());

    }
}