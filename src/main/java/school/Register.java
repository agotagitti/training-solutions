package school;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Register {

    public void newMark(Path file, int mark) {
        try {
            if (!Files.exists(file)) {
            Files.createFile(file);
        }
            Files.writeString(file, String.valueOf(mark) + "\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot access file", e);
        }
    }

    public void average(Path file) {
        try {
            List<String> marks = Files.readAllLines(file);
            int sumMarks = 0;
            for (String actual: marks) {
                sumMarks += Integer.parseInt(actual);
            }
            double average = sumMarks / marks.size();
            Files.writeString(file, "average: " + average, StandardOpenOption.APPEND);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Cannot access file", ioe);
        }
    }

}
