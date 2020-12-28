package interfacestaticmethods;

import java.util.List;

public interface Valued {

    double getValue();

    public static double sum(List<Valued> valueList) {
        double sumValues = 0.0;
        for (Valued actual: valueList) {
            sumValues += actual.getValue();
        }
        return sumValues;
    }

}
