package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private final List<Mark> marks = new ArrayList<>();
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public double calculateAverage() {
        double sumMark = 0.0;
        double result = 0.0;
        for (Mark foundMark: marks) {
            sumMark += foundMark.getMarkType().getValue();
        }
        if (marks.size() != 0) {
            result = sumMark / marks.size();
        }
        return result;
    }

    public double calculateSubjectAverage(Subject subject) {
        double sumMark = 0.0;
        double result = 0.0;
        int counter = 0;
        for (Mark foundMark: marks) {
            if (foundMark.getSubject().getSubjectName().equals(subject.getSubjectName())) {
                sumMark += foundMark.getMarkType().getValue();
                counter++;
            }
        }
        if (counter != 0) {
            result = sumMark / counter;
        }
        return result;
    }

    public void grading(Mark mark) {
        if (mark != null) {
            marks.add(mark);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "marks=" + marks +
                ", name='" + name + '\'' +
                '}';
    }

    private boolean isEmpty(String str) {
        boolean isEmpty = false;
        if (str != null) {
            if(str.trim().equals("")) {
                isEmpty = true;
            }
        } else {
            isEmpty = true;
        }
        return isEmpty;
    }
}
