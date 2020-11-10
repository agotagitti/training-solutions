package enumtype.week;

import java.util.ArrayList;
import java.util.List;

public class WorkdayCalculator {

    public List<DayType> dayTypes(Day firstDay, int numberOfDays) {
        List<DayType> typesOfDays = new ArrayList<>();
        Day day = firstDay;
        for (int i = 0; i < numberOfDays; i++) {
            typesOfDays.add(day.getDayType());
            day = nextDay(day);
        }
        return typesOfDays;
    }

    private Day nextDay(Day day) {
        int x = day.ordinal();
        Day[] array = Day.values();
            if (x == array.length - 1) {
                x = 0;
            } else {
                x += 1;
            }
        Day a = array[x];
        return a;
    }
}
