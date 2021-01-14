package week11d02;

import java.util.ArrayList;
import java.util.List;

public class Courier {

    private List<Ride> rides = new ArrayList<>();

    public Courier(List<Ride> rides) {
        this.rides = rides;
    }

    public Courier() {
    }

    public void addRide(Ride ride) {
        if (ride == null) {
            throw new IllegalArgumentException("No ride");
        }
        if (validateDayNumber(ride) && validateRideNumber(ride)) {
            rides.add(ride);
        }
    }

    private boolean validateDayNumber(Ride ride) {
        if (rides.isEmpty() || rides.get(rides.size() - 1).getDayNumber() <= ride.getDayNumber()) {
            return true;
        }
        throw new IllegalArgumentException("Invalid day");
    }

    private boolean validateRideNumber(Ride ride) {
        int lastDayNumber = 0;
        if (!rides.isEmpty()) {
            lastDayNumber = rides.get(rides.size() - 1).getDayNumber();
        }
        if (((lastDayNumber != ride.getDayNumber()) && ride.getRideNumber() == 1) ||
                (lastDayNumber == ride.getDayNumber() && ride.getRideNumber() - rides.get(rides.size() - 1).getRideNumber() == 1)) {
            return true;
        }
        throw new IllegalArgumentException("Invalid ride number");
    }

    public int getEarliestHoliday() {
        for (int i = 1; i <= 7; i++) {
            boolean found = false;
            for (Ride actual: rides) {
                if (actual.getDayNumber() == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return i;
            }
        }
        return 0;
    }

    public List<Ride> getRides() {
        return rides;
    }
}