package week14d03;

import java.util.*;

public class Student {

    private Map<String, List<Integer>> marks = new HashMap<>();

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void setMark(String subject, int mark) {
        if (!marks.containsKey(subject)) {
            marks.put(subject, new ArrayList<>());
        }
        marks.get(subject).add(mark);
    }

    public Map<String, List<Integer>> getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }
}
