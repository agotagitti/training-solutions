package iodatastream.statistics;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class HeightStatistics {

    public void saveHeights(List<Integer> heights, Path fileName) {
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(
                Files.newOutputStream(fileName)))) {
            dos.writeInt(heights.size());
            for (Integer actual: heights) {
                dos.writeInt(actual);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file", e);
        }
    }

}
