package intromethods;

import java.time.Year;

public class EmployeeMain {

    public static void main(String[] args) {
        Employee employee = new Employee("Jane Doe", Year.of(2010), 100000);

        System.out.println(employee.toString());

        employee.raiseSalary(20000);
        employee.setName("Jill Doe");

        System.out.println(employee.getName());
        System.out.println(employee.getSalary());

        System.out.println(employee.toString());

    }
}
