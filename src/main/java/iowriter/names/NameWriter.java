package iowriter.names;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NameWriter {

    private Path path;

    public NameWriter(Path path) {
        this.path = path;
    }

    public void addAndWrite(String name) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
            bufferedWriter.write(name + "\n");
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }

    }
}
