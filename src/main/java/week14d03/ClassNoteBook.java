package week14d03;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ClassNoteBook {

    private List<Student> students;

    public ClassNoteBook(List<Student> students) {
        this.students = students;
    }

    public Map<String, Map<String, List<Integer>>> sortNotebook() {
        Map<String, Map<String, List<Integer>>> sortedStudentList = new TreeMap<>();
        for (Student actual: students) {
            sortedStudentList.put(actual.getName(), actual.getMarks());
        }
        return sortedStudentList;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student("Jane");
        Student student2 = new Student("Jack");
        Student student3 = new Student("Joe");
        student1.setMark("B", 1);
        student2.setMark("E", 2);
        student3.setMark("C", 3);
        student1.setMark("á", 3);
        student2.setMark("F", 4);
        student3.setMark("A", 1);
        students.add(student1);
        students.add(student2);
        students.add(student3);


        ClassNoteBook classNoteBook = new ClassNoteBook(students);
        System.out.println(classNoteBook.sortNotebook().toString());
    }

}
