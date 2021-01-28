package week13d04;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TemplateMergerTest {

    private static final String MERGE_TEXT = "Az alkalmazott neve: {nev}, születési éve: {ev}";

    private TemplateMerger templateMerger = new TemplateMerger();

    @TempDir
    public Path tempFolder;

    @Test
    void merge() throws IOException {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John Doe", 1));
        employees.add(new Employee("Jane Doe", 2));

        Path file = Files.createFile(tempFolder.resolve("employee-template.txt"));
        Files.write(file, MERGE_TEXT.getBytes());

        StringBuilder validate = new StringBuilder();
        for (Employee actual: employees) {
            validate.append(MERGE_TEXT.replace("{nev}", actual.getName()).
                    replace("{ev}", String.valueOf(actual.getYearOfBirth())));
            validate.append("\n");
        }

        assertEquals(validate.toString(), templateMerger.merge(file, employees));
    }
}