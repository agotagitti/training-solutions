//nincs kész

package schoolrecords;

import java.util.*;

public class SchoolRecordsController {

    private List<Subject> subjectList = new ArrayList<>();
    private List<Tutor> tutorList = new ArrayList<>();
    private ClassRecords classRecords;

    public SchoolRecordsController() {
        classRecords = new ClassRecords("Fourth Grade A", new Random(5));
    }

    public static void main(String[] args) {
    SchoolRecordsController recordsController = new SchoolRecordsController();
    recordsController.initSchool();
    while (true) {
        recordsController.printMenu();
        Scanner scanner = new Scanner(System.in);
        int menuPoint = 0;
        if (scanner.hasNextInt()) {
            menuPoint = scanner.nextInt();
            scanner.nextLine();
            switch (menuPoint) {
                case 1:
                    recordsController.listStudentNames();
                    break;
                case 2:
                    recordsController.findStudentByName();
                    break;
                case 11:
                    break;
                default:
                    System.out.println("Válasszon menüt 1-11-ig!");
            }
            if (menuPoint == 11) {
                break;
            }
        } else {
            System.out.println("Nem valid menüpont!");
        }

    }


    }

    public void initSchool() {
        Tutor tutor = new Tutor("Nagy Csilla",
                Arrays.asList(new Subject("földrajz"),
                        new Subject("matematika"),
                        new Subject("biológia"),
                        new Subject("zene"),
                        new Subject("fizika"),
                        new Subject("kémia")));

        Student firstStudent = new Student("Kovács Rita");
        Student secondStudent = new Student("Nagy Béla");
        Student thirdStudent = new Student("Varga Márton");

        firstStudent.grading(new Mark(MarkType.A, new Subject("földrajz"), tutor));
        firstStudent.grading(new Mark(MarkType.B, new Subject("matematika"), tutor));
        firstStudent.grading(new Mark(MarkType.C, new Subject("földrajz"), tutor));

        secondStudent.grading(new Mark(MarkType.B, new Subject("biológia"), tutor));
        secondStudent.grading(new Mark(MarkType.C, new Subject("matematika"), tutor));
        secondStudent.grading(new Mark(MarkType.D, new Subject("zene"), tutor));

        thirdStudent.grading(new Mark(MarkType.F, new Subject("fizika"), tutor));
        thirdStudent.grading(new Mark(MarkType.A, new Subject("kémia"), tutor));
        thirdStudent.grading(new Mark(MarkType.B, new Subject("földrajz"), tutor));

        classRecords.addStudent(firstStudent);
        classRecords.addStudent(secondStudent);
        classRecords.addStudent(thirdStudent);
    }

    public void printMenu() {
        System.out.println(
        "1. Diákok nevének listázása\n" +
        "2. Diák név alapján keresése\n" +
        "3. Diák létrehozása\n" +
        "4. Diák név alapján törlése\n" +
        "5. Diák feleltetése\n" +
        "6. Osztályátlag kiszámolása\n" +
        "7. Tantárgyi átlag kiszámolása\n" +
        "8. Diákok átlagának megjelenítése\n" +
        "9. Diák átlagának kiírása\n" +
        "10. Diák tantárgyhoz tartozó átlagának kiírása\n" +
        "11. Kilépés");
    }

    private void listStudentNames() {
        System.out.println(classRecords.listStudentNames());
    }

    private void findStudentByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérem a keresendő diák nevét!");
        String name = scanner.nextLine();
        try {
            System.out.println(classRecords.findStudentByName(name));
        } catch (IllegalStateException | IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    



}
