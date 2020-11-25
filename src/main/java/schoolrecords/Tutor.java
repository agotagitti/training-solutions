package schoolrecords;

import java.util.List;

public class Tutor {

    private String name;
    private List<Subject> taughtSubjects;

    public Tutor(String name, List<Subject> taughtSubjects) {
        this.name = name;
        this.taughtSubjects = taughtSubjects;
    }

    public String getName() {
        return name;
    }

    public boolean tutorTeachingSubject(Subject subject) {
        //tanítja vagy sem a paraméterként kapott tantárgyat
        boolean foundSubject = false;
        for (Subject subj: taughtSubjects) {
            if (subj.getSubjectName().equals(subject.getSubjectName())) {
                foundSubject = true;
                break;
            }
        }
        return foundSubject;
    }
}
