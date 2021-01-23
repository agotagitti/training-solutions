package ioreadwritebytes.temperatures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesReader {

    public Temperatures readTemperatures(String pathString) {
        Path path = Path.of(pathString);
        byte[] bytes = new byte[365];
        try {
            bytes = Files.readAllBytes(path);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file");
        }
        return  new Temperatures(bytes);
    }



}
