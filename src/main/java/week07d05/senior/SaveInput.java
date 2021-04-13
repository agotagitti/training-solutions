package week07d05.senior;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveInput {

    public void fileWriter(List<String> lines, String fileName) {
        Path path = Path.of(fileName);
        try(BufferedWriter bw = Files.newBufferedWriter(path)) {
            for(String actualLine : lines) {
                bw.write(actualLine + "\n");
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot write file", ioe);
        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> lineList = new ArrayList<>();
        String fileName = "";
        System.out.println("First line please");
        lineList.add(scanner.nextLine());
        System.out.println("Second line please");
        lineList.add(scanner.nextLine());
        System.out.println("Third line please");
        lineList.add(scanner.nextLine());
        System.out.println("File name please");
        fileName = scanner.nextLine();

        SaveInput saveInput = new SaveInput();
        saveInput.fileWriter(lineList, fileName);
    }


}
