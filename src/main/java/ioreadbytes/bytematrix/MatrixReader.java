package ioreadbytes.bytematrix;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MatrixReader {

    private List<byte[]> myMatrix = new ArrayList<>();

    public void readBytesAndCreateMatrix(String fileName) {
        Path path = Path.of(fileName);
        try (InputStream inputStream = new BufferedInputStream(Files.newInputStream(path))) {
            byte[] bytes = new byte[1000];
            int size = 0;
            while ((size = inputStream.read(bytes)) == 1000) {
                myMatrix.add(bytes);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    public int numberOfColumnsWhereMoreZeros() {
        byte[] columnValue = new byte[1000];
        for (byte[] actual: myMatrix) {
            for (int i = 0; i < 1000; i++) {
                if (actual[i] == '1') {
                    columnValue[i]++;
                }
            }
        }
        int countColumns = 0;
        for (byte actual: columnValue) {
            if (actual <= myMatrix.size() / 2) {
                countColumns++;
            }
        }
        return countColumns;
    }

    public List<byte[]> getMyMatrix() {
        return myMatrix;
    }
}
