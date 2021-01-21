package exceptionclass.course;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleTime {

    int hour;
    int minute;

    public SimpleTime(int hour, int minute) {
        validate(hour, minute);
        this.hour = hour;
        this.minute = minute;
    }

    public SimpleTime(String time) {
        if (time == null) {
            throw new InvalidTimeException("Time is null");
        }
        String[] timeData = time.split(":");
        if (timeData.length == 2) {
            try {
                validate(Integer.parseInt(timeData[0]), Integer.parseInt(timeData[1]));
            }
            catch (NumberFormatException nfe) {
                throw new InvalidTimeException("Time is not hh:mm");
            }
        } else {
            throw new InvalidTimeException("Time is not hh:mm");
        }
        this.hour = Integer.parseInt(timeData[0]);
        this.minute = Integer.parseInt(timeData[1]);
    }

    private void validate(int hour, int minute) {
        if (hour < 0 || hour > 23) {
            throw new InvalidTimeException("Hour is invalid (0-23)");
        }
        if (minute < 0 || minute > 59) {
            throw new InvalidTimeException("Minute is invalid (0-59)");
        }
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }
}
