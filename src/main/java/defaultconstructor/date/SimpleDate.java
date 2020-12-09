package defaultconstructor.date;

public class SimpleDate {

    private int year;
    private int month;
    private int day;

    public void setDate(int year, int month, int day) {
        if (year < 1900 || month < 1 || month > 12 || day < 1 || day > daysInMonth(year, month)) {
            throw new IllegalArgumentException("One or more given parameter cannot be applied! "
                    + year + ", " + month + ", " + day);
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    private int daysInMonth(int year, int month) {
        int numberOfDays = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numberOfDays = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numberOfDays = 30;
                break;
            case 2:
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    numberOfDays = 29;
                } else {
                    numberOfDays = 28;
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid month: " + month);
        }
        return numberOfDays;
    }
}
