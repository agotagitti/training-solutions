package ioreadstring.names;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private Path myFile;
    private List<Human> humans = new ArrayList<>();

    public FileManager(String file) {
        myFile = Path.of(file);
    }

    public void readFromFile() {
        try {
            List<String> names = Files.readAllLines(myFile);
            for (String actual: names) {
                String first = actual.substring(0, actual.indexOf(" "));
                String last = actual.substring(actual.indexOf(" ") + 1, actual.length());
                humans.add(new Human(first, last));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }
    }

    public Path getMyFile() {
        return myFile;
    }

    public List<Human> getHumans() {
        return new ArrayList<>(humans);
    }
}
