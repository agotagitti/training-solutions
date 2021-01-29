package week13d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SubjectSchedule {

    private List<Subject> subjects = new ArrayList<>();

    public void readSubjectsFromFile() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                SubjectSchedule.class.getResourceAsStream("/beosztas.txt")))) {
            String[] subjectLines = new String[4];
            while ((subjectLines[0] = br.readLine()) != null) {
                for (int i = 1; i < subjectLines.length; i++) {
                    subjectLines[i] = br.readLine();
                }
                subjects.add(
                        new Subject(subjectLines[0], subjectLines[1], subjectLines[2],Integer.parseInt(subjectLines[3])));
            }

        } catch (IOException | NullPointerException e) {
            throw new IllegalStateException("Cannot access file", e);
        }
    }

    public int getHoursByTeacher(String teacher) {
        int sumHours = 0;
        for (Subject actual: subjects) {
            if (actual.getTeacher().equals(teacher)) {
                sumHours += actual.getNumberOfLessons();
            }
        }
        return sumHours;
    }

    public static void main(String[] args) {
        SubjectSchedule ss = new SubjectSchedule();
        ss.readSubjectsFromFile();
       System.out.println(ss.subjects.size());
        System.out.println(ss.getHoursByTeacher("Albatrosz Aladin"));
    }

}
