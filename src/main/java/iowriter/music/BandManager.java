package iowriter.music;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BandManager {

    private List<Band> bands = new ArrayList<>();

    public void writeBandsBefore(Path outputFile, int year) {
        try (BufferedWriter bf = Files.newBufferedWriter(outputFile)) {
            for (Band actual: bands) {
                if (actual.getYear() < year) {
                    bf.write(actual.getName() + " " + actual.getYear() + "\n");
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file", e);
        }
    }

    public void readBandsFromFile(Path inputFile) {
        try (BufferedReader br = Files.newBufferedReader(inputFile)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] bandData = line.split(";");
                bands.add(new Band(bandData[0], Integer.parseInt(bandData[1])));
            }

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }
}
