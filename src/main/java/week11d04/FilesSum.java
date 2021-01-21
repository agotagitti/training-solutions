package week11d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesSum {

    public int sumNumber() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            Path path = Path.of("number" + String.format("%02d", i) + ".txt");
            if (Files.isRegularFile(path)) {
                try {
                    sum += Integer.parseInt(Files.readString(path));
                    System.out.println(path);
                }
                catch (IOException ioe) {
                    throw new IllegalStateException("Cannot read file");
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        FilesSum filesSum = new FilesSum();
        System.out.println(filesSum.sumNumber());
    }

}
