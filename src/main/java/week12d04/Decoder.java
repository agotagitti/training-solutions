package week12d04;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Decoder {

    public void decodingFromByte() {
        Path path = Path.of("secret.dat");
        try (InputStream inputStream = new BufferedInputStream(Files.newInputStream(path))) {
            byte[] buffer = new byte[1000];
            int size;
            while ((size = inputStream.read(buffer)) > 0) {
                for (int i = 0; i < size; i++) {
                    System.out.print((char) (buffer[i] + 10));
                }
            }
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }


    public static void main(String[] args) {
        Decoder decoder = new Decoder();
        decoder.decodingFromByte();
    }
}
