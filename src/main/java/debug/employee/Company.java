package debug.employee;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private List<Employee> employees;

    public Company(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee findEmployeeByName(String name) {
        for (Employee empObj: employees) {
            if (empObj.getName().equals(name)) {
               return empObj;
            }
        } return null;
    }

    public  List<String> listEmployeeNames() {
        List<String> empNameList = new ArrayList<>();
        for (Employee empObj: employees) {
            empNameList.add(empObj.getName());
        }
        return empNameList;
    }


}
