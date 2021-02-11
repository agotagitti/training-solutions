package iozip.names;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class EmployeeFileManager {

    public void saveEmployees(Path path, List<String> employees) {
        try (ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            zos.putNextEntry(new ZipEntry("names.dat"));
            for (String actual: employees) {
                zos.write(actual.getBytes());
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file", e);
        }
    }

}
