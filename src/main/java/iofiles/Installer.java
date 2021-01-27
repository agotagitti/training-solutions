package iofiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Installer {

    private static final String INSTALL_SOURCE_FOLDER = "/install/";
    private static final String INSTALL_FILE = "install.txt";

    public void install(String targetDirectory) {
        Path targetPath = Path.of(targetDirectory);
        if (!Files.exists(targetPath) || !Files.isDirectory(targetPath)) {
            throw new IllegalArgumentException("The given directory doesn't exist");
        }

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                        Installer.class.getResourceAsStream(INSTALL_SOURCE_FOLDER + INSTALL_FILE)))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.endsWith("/")) {
                    Files.createDirectory(targetPath.resolve(line));
                } else {
                    Files.copy(Installer.class.getResourceAsStream(INSTALL_SOURCE_FOLDER + line),
                            targetPath.resolve(line), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }
}
