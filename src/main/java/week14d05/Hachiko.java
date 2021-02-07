package week14d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Hachiko {

    public Map<String, Integer> countWords(Path path, String...words) {
        Map<String, Integer> result = new HashMap<>();
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                for(String actual: words) {
                    if (line.toLowerCase().contains(actual.toLowerCase())) {
                        if (!result.containsKey(actual)) {
                            result.put(actual, 0);
                        }
                        result.put(actual, result.get(actual) + 1);
                    }
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
        return result;
    }

    public static void main(String[] args) {
        Hachiko hachiko = new Hachiko();
        Path path = Path.of("src/main/resources/hachiko.srt");
        String[] words = {"Hachiko", "haza", "pályaudvar", "jó"};
        System.out.println(hachiko.countWords(path, words));
    }

}
