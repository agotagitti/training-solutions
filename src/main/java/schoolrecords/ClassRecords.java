package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {

    private String className;
    private Random rnd;
    private List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random rnd) {
        this.className = className;
        this.rnd = rnd;
    }

    public boolean addStudent(Student student) {
        //felvesz egy diákot az osztályba, ha még nincs benne
        if (student == null) {
            throw new NullPointerException("Student name must not be empty!");
        }
        boolean alreadyStudent = true;
        for (Student actual: students) {
            if (actual.getName().equals(student.getName())) {
                alreadyStudent = false;
            }
        }
        if (alreadyStudent) {
            students.add(student);
        }
        return alreadyStudent;
    }

    public double calculateClassAverage() {
        //osztályátlagot számol, minden diákot figyelembe véve
        if (students.size() == 0) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        double average = 0.0;
        for (Student actual: students) {
            average += actual.calculateAverage();
        }
        if (average == 0.0) {
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }
        return Math.round((average / students.size()) * 100) / 100.0;
    }

    public double calculateClassAverageBySubject(Subject subject) {
        //tantárgy szerinti osztályátlagot számol
        //kihagyja azokat a diákokat, akiknek nincs jegye
        double sumGrades = 0.0;
        int counter = 0;
        for (Student actual: students) {
            if (actual.calculateSubjectAverage(subject) != 0.0) {
                sumGrades += actual.calculateSubjectAverage(subject);
                counter++;
            }
        }
        if (counter == 0) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        return Math.round((sumGrades / counter) * 100) / 100.0;
    }

    public Student findStudentByName(String name) {
        //név szerint megkeres egy diákot az osztályban
        if (students.size() == 0) {
            throw new IllegalStateException("No students to search!");
        }
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        Student foundStudent = null;
        for (Student actual: students) {
            if (actual.getName().equals(name)) {
                foundStudent = actual;
            }
        }
        if (foundStudent == null) {
            throw new IllegalArgumentException("Student by this name cannot be found! " + name);
        }
        return foundStudent;
    }

    public String listStudentNames() {
        //kilistázza a diákok neveit, vesszővel ellátva
        String namesOfStudents = "";
        for (Student actual: students) {
            if (namesOfStudents.equals("")) {
                namesOfStudents += actual.getName();
            } else {
                namesOfStudents += ", " + actual.getName();
            }
        }
        return namesOfStudents;
    }

    public List<StudyResultByName> listStudyResults() {
        //a diákok nevét és tanulmányi átlagát  egy-egy új objektumba viszi
        //és azok listáját adja vissza
        List<StudyResultByName> studyResultByNameList = new ArrayList<>();
        for (Student actual: students) {
            studyResultByNameList.add(new StudyResultByName(actual.getName(), Math.round(actual.calculateAverage() * 100) / 100.0));
        }
        return studyResultByNameList;
    }

    public boolean removeStudent(Student student) {
        //kivesz egy diákot az osztályból
        boolean result = false;
        for (Student actual: students) {
            if (actual.getName().equals(student.getName())) {
                result = students.remove(actual);
            }
        }
        return result;
    }

    public Student repetition() {
        //felelethez random módon kiválaszt egy diákot
        if (students.size() == 0) {
            throw new IllegalStateException("No students to select for repetition!");
        }
        return students.get(rnd.nextInt(students.size()));
    }

    public String getClassName() {
        return className;
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
