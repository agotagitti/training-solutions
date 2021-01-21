package exceptionclass.course;

public class Course {

    private String name;
    private SimpleTime begin;

    public Course(String name, SimpleTime begin) {
        if (name == null) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
        if (begin == null) {
            throw new IllegalArgumentException("Invalid beginning time");
        }
        this.begin = begin;
    }

    public String getName() {
        return name;
    }

    public SimpleTime getBegin() {
        return begin;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", begin, name);
    }

}
