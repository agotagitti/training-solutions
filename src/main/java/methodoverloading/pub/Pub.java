package methodoverloading.pub;

import methodoverloading.Time;

public class Pub {

    private String name;
    private Time openFrom;

    public Pub(String name, int hours, int minutes) {
        this.name = name;
        this.openFrom = new Time(hours, minutes);
    }

    public String getName() {
        return name;
    }

    public Time getOpenFrom() {
        return openFrom;
    }

    @Override
    public String toString() {
        //"Kurta kocsma;10:30"
        return name + ";" + openFrom.getHours() + ":" + openFrom.getMinutes();
    }
}
