package methodstructure.pendrives;

import java.util.List;

public class Pendrives {

    public Pendrive best(List<Pendrive> pendriveList) {
       Pendrive result = null;
        for (Pendrive actual: pendriveList) {
           if (result == null || result.comparePricePerCapacity(actual) == 1) {
               result = actual;
            }
       }
        return result;
    }

    public Pendrive cheapest(List<Pendrive> pendriveList) {
        Pendrive result = null;
        for (Pendrive actual: pendriveList) {
            if (result == null || !result.cheaperThan(actual)) {
                result = actual;
            }
        }
        return result;
    }

    public void risePriceWhereCapacity(List<Pendrive> pendriveList, int percent, int capacity) {
        for (Pendrive actual: pendriveList) {
            if (actual.getCapacity() == capacity) {
                actual.risePrice(percent);
            }
        }
    }

}
