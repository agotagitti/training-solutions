package timesheet;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class TimeSheetItem {

    private final Employee employee;
    private final Project project;
    private final LocalDateTime beginDate;
    private final LocalDateTime endDate;

    public TimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {
        this.employee = employee;
        this.project = project;
        if(!beginDate.toLocalDate().equals(endDate.toLocalDate())) {
            throw new IllegalArgumentException("Begin and end date have to be the same");
        }
        if (endDate.isBefore(beginDate)) {
            throw new IllegalArgumentException("Project beginning have to be before project end");
        }
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public long hoursBetweenDates() {
        return Duration.between(beginDate, endDate).toHours();
    }

    public Employee getEmployee() {
        return employee;
    }

    public Project getProject() {
        return project;
    }

    public LocalDateTime getBeginDate() {
        return beginDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeSheetItem that = (TimeSheetItem) o;
        return employee.equals(that.employee) && project.equals(that.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, project);
    }
}
