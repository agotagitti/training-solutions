package week13d03;

public class Subject {

    private String teacher;
    private String subjectName;
    private String className;
    private int NumberOfLessons;

    public Subject(String teacher, String subjectName, String className, int numberOfLessons) {
        this.teacher = teacher;
        this.subjectName = subjectName;
        this.className = className;
        NumberOfLessons = numberOfLessons;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getClassName() {
        return className;
    }

    public int getNumberOfLessons() {
        return NumberOfLessons;
    }
}
