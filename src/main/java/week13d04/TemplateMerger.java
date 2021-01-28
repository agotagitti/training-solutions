package week13d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TemplateMerger {

    public String merge(Path file, List<Employee> employees) {
        StringBuilder merged = new StringBuilder();
        try {
            String template = Files.readString(file);
            for (Employee actual: employees) {
                merged.append(template.replace("{nev}", actual.getName()).
                        replace("{ev}", String.valueOf(actual.getYearOfBirth())));
                merged.append("\n");
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
        return merged.toString();
    }

}
