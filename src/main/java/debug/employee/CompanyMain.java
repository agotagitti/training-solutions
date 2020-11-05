package debug.employee;

import java.util.ArrayList;
import java.util.List;

public class CompanyMain {

    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        Company test = new Company(empList);
        Employee emp1 = new Employee("Jane Doe", 1980);
        Employee emp2 = new Employee("John Doe", 1981);
        Employee emp3 = new Employee("Jill Doe", 1982);

        test.addEmployee(emp1);
        test.addEmployee(emp2);
        test.addEmployee(emp3);

        Employee empReturn = test.findEmployeeByName("Jill Doe");

        System.out.println(empReturn.getName());

        System.out.println(empReturn.getYearOfBirth());

        System.out.println(test.listEmployeeNames().toString());

    }

}
