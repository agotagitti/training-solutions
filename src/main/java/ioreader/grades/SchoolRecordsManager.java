package ioreader.grades;

import week12d05.Index;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SchoolRecordsManager {

    private List<Student> students = new ArrayList<>();

    public void readGradesFromFile(String fileName) {
        Path path = Path.of("src/main/resources/" + fileName);
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] studentData = line.split(" ");
                List<Integer> studentGrades = new ArrayList<>();
                for (int i = 1; i < studentData.length; i++) {
                    studentGrades.add(Integer.parseInt(studentData[i]));
                }
                students.add(new Student(studentData[0], studentGrades));
            }
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }

    }

    public double classAverage() {
        double sumClassGrades = 0.0;
        for (Student actual: students) {
            sumClassGrades += actual.average();
        }
        return sumClassGrades / students.size();
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }



}
