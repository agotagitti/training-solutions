package intromethods;

import java.time.Year;

public class Employee {

    private String name;
    private Year hiringYear;
    private int salary;

    public Employee(String name, Year hiringYear, int salary) {
        this.name = name;
        this.hiringYear = hiringYear;
        this.salary = salary;
    }

    public void raiseSalary(int raise) {
        salary += raise;
    }

    @Override
    public String toString() {
        return "Employee: " +
                "Name = '" + name + '\'' +
                ", Hiring Year = " + hiringYear +
                ", Salary = " + salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Year getHiringYear() {
        return hiringYear;
    }

    public int getSalary() {
        return salary;
    }
}
