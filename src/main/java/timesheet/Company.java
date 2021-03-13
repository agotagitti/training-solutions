package timesheet;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Company {

    private List<Project> projects;
    private List<Employee> employees;
    private List<TimeSheetItem> timeSheetItems = new ArrayList<>();

    public Company (InputStream employeesFile, InputStream projectsFile) {
        try {
            employees = readEmployeesFromFile(employeesFile);
            projects = readProjectsFromFile(projectsFile);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot access file", ioe);
        }
    }

    private List<Employee> readEmployeesFromFile(InputStream employeesFile) throws IOException{
        List<Employee> employeesFromFile = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(employeesFile));
        String line;
        while ((line = br.readLine()) != null) {
            String[] employeeData = line.split(" ");
            employeesFromFile.add(new Employee(employeeData[0], employeeData[1]));
        }
        return employeesFromFile;
    }

    private List<Project> readProjectsFromFile(InputStream projectsFile) throws IOException{
        List<Project> projectsFromFile = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(projectsFile));
        String line;
        while ((line = br.readLine()) != null) {
           projectsFromFile.add(new Project(line));
        }
        return projectsFromFile;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<TimeSheetItem> getTimeSheetItems() {
        return timeSheetItems;
    }

    public void addTimeSheetItem(Employee employee, Project project, LocalDateTime begin, LocalDateTime end) {
        if (!employees.contains(employee)) {
            throw new IllegalArgumentException("Invalid employee name1");
        }
        if (!projects.contains(project)) {
            throw new IllegalArgumentException("Invalid project name2");
        }
        timeSheetItems.add(new TimeSheetItem(employee, project, begin, end));
    }

    public List<ReportLine> calculateProjectByNameYearMonth(String employeeName, int year, int month) {
        if (!isEmployeeExist(employeeName)) {
            throw new IllegalArgumentException("Invalid employee name3");
        }
        List<ReportLine> foundReports = new ArrayList<>();
        for (Project actualProject : projects) {
            foundReports.add(new ReportLine(actualProject, getHourForProject(actualProject, employeeName, year, month)));
        }
        return foundReports;

    }

    private long getHourForProject(Project project, String employeeName, int year, int month) {
        long hours = 0L;
        for (TimeSheetItem actualTimeSheetItem : timeSheetItems) {
            if (actualTimeSheetItem.getProject().equals(project)
                    &&actualTimeSheetItem.getEmployee().getName().equals(employeeName)
                    && actualTimeSheetItem.getBeginDate().getYear() == year
                    && actualTimeSheetItem.getBeginDate().getMonthValue() == month) {
                hours += actualTimeSheetItem.hoursBetweenDates();
            }
        }
        return hours;
    }

    private boolean isEmployeeExist(String employeeName) {
        for (Employee actualEmployee : employees) {
            if (actualEmployee.getName().equals(employeeName)) {
                return true;
            }
        }
        return false;
    }

    public void printToFile(String employeeName, int year, int month, Path file) {
        List<ReportLine> reportLines = calculateProjectByNameYearMonth(employeeName, year, month);
        long sumHours = getSumHours(reportLines);
        String formattedMonth = String.format("%02d", month);
        try (BufferedWriter bw = Files.newBufferedWriter(file)) {
            bw.write(employeeName + "\t");
            bw.write(year + "-" + formattedMonth + "\t");
            bw.write(sumHours + "\n");
            printProjectsToFile(reportLines, bw);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write into file", e);
        }
    }

    private long getSumHours(List<ReportLine> reportLines) {
        long sumHours = 0L;
        for (ReportLine actualReportLine : reportLines) {
            sumHours += actualReportLine.getTime();
        }
        return sumHours;
    }

    private void printProjectsToFile(List<ReportLine> reportLines, BufferedWriter bw) throws IOException {
        for (ReportLine actualReportLine : reportLines) {
            if (actualReportLine.getTime() != 0) {
                bw.write(actualReportLine.getProject().toString() + "\t");
                bw.write(actualReportLine.getTime() + "\n");
            }
        }
    }



}
