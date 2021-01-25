package ioprintwriter.salary;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SalaryWriter {

    private List<String> names;

    public SalaryWriter(List<String> names) {
        this.names = names;
    }

    public void writeNamesAndSalaries(Path file) {
        try (PrintWriter printWriter = new PrintWriter(Files.newBufferedWriter(file))) {
            for (String actual: names) {
                printWriter.print(actual + ": ");
                if (actual.startsWith("Dr")) {
                    printWriter.println(500_000);
                } else if (actual.startsWith("Mr") || actual.startsWith("Mrs")) {
                    printWriter.println(200_000);
                } else {
                    printWriter.println(100_000);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file", e);
        }

    }
}
