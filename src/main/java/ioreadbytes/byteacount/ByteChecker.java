package ioreadbytes.byteacount;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByteChecker {

    public int readBytesAndFindAs(String fileName) {
        Path path = Path.of(fileName);
        int countA = 0;
        try(InputStream inputStream = new BufferedInputStream(Files.newInputStream(path))) {
            byte[] bytes = new byte[1000];
            int size = 0;
            while ((size = inputStream.read(bytes)) > 0) {
                for (int i = 1; i < size; i++) {
                    if (bytes[i] == 'a') {
                        countA ++;
                    }
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
        return countA;
    }

}
