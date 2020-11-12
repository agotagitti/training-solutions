package controlselection.week;

import java.util.List;

public class DayOfWeeks {

    public String whichDay(String day) {
        String days = day.toLowerCase();
        switch (days) {
            case "hétfő":
                days = "hét eleje";
                break;
            case "kedd":
            case "szerda":
            case "csütörtök":
                days = "hét közepe";
                break;
            case "péntek":
                days = "majdnem hétvége";
                break;
            case "szombat":
            case "vasárnap":
                days = "hét vége";
                break;
            default:
                throw new IllegalArgumentException("Invalid day: " + day);
        }
        return days;
    }
}
