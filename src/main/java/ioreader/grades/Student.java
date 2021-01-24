package ioreader.grades;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private List<Integer> gradeList;

    public Student(String name, List<Integer> gradeList) {
        this.name = name;
        this.gradeList = gradeList;
    }

    public String getName() {
        return name;
    }

    public double average() {
        double sumMarks = 0;
        for(Integer actual: gradeList) {
            sumMarks +=actual;
        }
        return sumMarks / gradeList.size();
    }

    public boolean isIncreasing() {
            for (int i = 0; i < gradeList.size() - 1; i++) {
                if (gradeList.get(i) >= gradeList.get(i + 1)) {
                    return false;
                }
            }
        return true;
    }

    public List<Integer> getGradeList() {
        return new ArrayList<>(gradeList);
    }
}
