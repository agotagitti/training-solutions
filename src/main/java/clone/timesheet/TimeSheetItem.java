package clone.timesheet;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeSheetItem {

    private String employee;
    private String project;
    private LocalDateTime from;
    private LocalDateTime to;

    public TimeSheetItem(String employee, String project, LocalDateTime from, LocalDateTime to) {
        this.employee = employee;
        this.project = project;
        this.from = from;
        this.to = to;
    }

    public TimeSheetItem(TimeSheetItem timeSheetItem) {
        this.employee = timeSheetItem.employee;
        this.project = timeSheetItem.project;
        this.from = timeSheetItem.from;
        this.to = timeSheetItem.to;
    }

    public static TimeSheetItem withDifferentDay(TimeSheetItem timeSheetItem, LocalDate localDate) {
        TimeSheetItem timeSheetItemCopy = new TimeSheetItem(timeSheetItem);
        timeSheetItemCopy.from = LocalDateTime.of(localDate, timeSheetItemCopy.from.toLocalTime());
        timeSheetItemCopy.to = LocalDateTime.of(localDate, timeSheetItemCopy.to.toLocalTime());
        return timeSheetItemCopy;
    }

    public String getEmployee() {
        return employee;
    }

    public String getProject() {
        return project;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

}
