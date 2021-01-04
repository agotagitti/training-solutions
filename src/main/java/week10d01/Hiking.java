package week10d01;

import java.util.ArrayList;
import java.util.List;

public class Hiking {

    private List<GPS> gpsList;

    public Hiking(List<GPS> gpsList) {
        this.gpsList = gpsList;
    }

    public float getPlusElevation(List<Float> altitudes) {
        float gpsSum = 0.0f;
        for (int i = 0; i < altitudes.size() - 1; i++) {
            if (altitudes.get(i) - altitudes.get(i + 1) < 0) {
                gpsSum += altitudes.get(i + 1) - altitudes.get(i);
            }
        }
        return gpsSum;
    }

    public List<Float> getAltitudes() {
        List<Float> altitudes = new ArrayList<>();
        for (GPS actual: gpsList) {
            altitudes.add(actual.getZ());
        }
        return altitudes;
    }

    public List<GPS> getGpsList() {
        return gpsList;
    }

}
