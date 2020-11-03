package introdate;

public class EmployeeTest {

    public static void main(String[] args) {

        Employee employee1 = new Employee(2020,11,3,"Jane Doe");
        System.out.println("Our new employee: " + employee1.getName());
        System.out.println("Date of birth: " + employee1.getDateOfBirth());
        System.out.println("Begin of Employement: " + employee1.getBeginEmployment());

    }

}
