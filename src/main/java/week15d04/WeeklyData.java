package week15d04;

public class WeeklyData implements Comparable<WeeklyData> {

    private String weekNumber;
    private int caseNumber;

    public WeeklyData(String weekNumber, int caseNumber) {
        this.weekNumber = weekNumber;
        this.caseNumber = caseNumber;
    }

    public String getWeekNumber() {
        return weekNumber;
    }

    public int getCaseNumber() {
        return caseNumber;
    }

    @Override
    public String toString() {
        return "WeeklyData{" +
                "weekNumber='" + weekNumber + '\'' +
                ", caseNumber=" + caseNumber +
                '}';
    }

    @Override
    public int compareTo(WeeklyData o) {
        return o.caseNumber - this.caseNumber;
    }
}
