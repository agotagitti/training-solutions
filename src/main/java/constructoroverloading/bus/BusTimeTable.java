package constructoroverloading.bus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BusTimeTable {

    private List<SimpleTime> timeTable = new ArrayList<>();

    public BusTimeTable(List<SimpleTime> timeTable) {
        this.timeTable = timeTable;
    }

    public BusTimeTable(int firstHour, int lastHour, int everyMinute) {
        List<SimpleTime> newTimeTable = new ArrayList<>();
        for (int i = firstHour; i <= lastHour; i++) {
            newTimeTable.add(new SimpleTime(i, everyMinute));
        }
        timeTable = newTimeTable;
    }

    public SimpleTime nextBus(SimpleTime actual) {
        SimpleTime nextBusTime = null;
        for (SimpleTime x: timeTable) {
            if (x.difference(actual) > 0 && (nextBusTime == null || x.difference(nextBusTime) < 0)) {
                nextBusTime = x;
            }
        }
        if (nextBusTime == null) {
            throw new IllegalStateException("No more buses today!");
        }
        return nextBusTime;
    }

    public SimpleTime firstBus() {
        SimpleTime firstBusTime = null;
        for (SimpleTime x: timeTable) {
            if (firstBusTime == null || x.difference(firstBusTime) < 0) {
                firstBusTime = x;
            }
        }
        if (firstBusTime == null) {
            throw new IllegalStateException("No buses today!");
        }
        return firstBusTime;
    }

    public List<SimpleTime> getTimeTable() {
        return timeTable;
    }

}
