package week07d03.senior;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Date {

    private final int year;
    private final int month;
    private final int day;

    public Date(int year, int month, int day) {
        try {
            LocalDate.of(year, month, day);
        }
        catch (DateTimeException dte) {
            throw new IllegalArgumentException("Invalid date");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static Date dateMaker(int year, int month, int day) {
        return new Date(year, month, day);
    }

    public Date withYear(int year) {
        return dateMaker(year, month, day);
    }

    public Date withMonth(int month) {
        return dateMaker(year, month, day);
    }

    public Date withDay(int day) {
        return dateMaker(year, month, day);
    }

}