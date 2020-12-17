package week08d03;

import java.util.ArrayList;
import java.util.List;

public class StringList {

    public List<String> stringListsUnion(List<String> first, List<String> second) {
        List<String> unitedList = new ArrayList<>(first);
        boolean found = false;
        for (String x: second) {
            found = false;
            for (String y: unitedList) {
                if (x.equals(y)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                unitedList.add(x);
            }
        }
        return unitedList;
    }


    public List<String> stringListsUnion2(List<String> first, List<String> second) {
        List<String> unitedList = new ArrayList<>(first);
        for (String x: second) {
            if (!unitedList.contains(x)) {
                    unitedList.add(x);
            }
        }
        return unitedList;
    }

}
