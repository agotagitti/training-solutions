package immutable.satellite;

import java.util.ArrayList;
import java.util.List;

public class SpaceAgency {

    List<Satellite> satellites = new ArrayList<>();

    public void registerSatellite(Satellite satellite) {
        if (satellite == null) {
            throw new NullPointerException("Parameter must not be null!");
        }
        if (satellites.contains(satellite)) {
            throw new IllegalArgumentException("Satellite is already on the list!");
        }
        satellites.add(satellite);
    }

    public Satellite findSatelliteByRegisterIdent(String registerIdent) {
        if (isEmpty(registerIdent)) {
            throw new IllegalArgumentException("Register ident must not be empty!");
        }
        for (Satellite actual: satellites) {
            if (actual.getRegisterIdent().equals(registerIdent)) {
                return actual;
            }
        }
        throw new IllegalArgumentException("Satellite with the given registration cannot be found!" + registerIdent);
    }

    private boolean isEmpty(String string) {
        return string == null || "".equals(string.trim());
    }

    @Override
    public String toString() {
        return satellites.toString();
    }
}
