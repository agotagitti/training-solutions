package exam03;

import java.time.LocalDate;
import java.util.*;

public class Cruise {

    private Boat boat;
    private LocalDate sailing;
    private double basicPrice;
    private List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public void bookPassenger(Passenger passenger) {
        if (passengers.size() < boat.getMaxPassengers()) {
            passengers.add(passenger);
        } else {
            throw new IllegalArgumentException("Boat is full!");
        }
    }

    public double getPriceForPassenger(Passenger passenger) {
        return basicPrice * passenger.getCruiseClass().getMultiplier();
    }

    public Passenger findPassengerByName(String name) {
        for (Passenger actual : passengers) {
            if (actual.getName().equals(name)) {
                return actual;
            }
        }
        throw new CannotFindPassengerException("Cannot find passenger: " + name);
    }

    public List<String> getPassengerNamesOrdered() {
        List<String> nameList = new ArrayList<>();
        for (Passenger actual : passengers) {
            nameList.add(actual.getName());
        }
        Collections.sort(nameList);
        return nameList;
    }

    public double sumAllBookingsCharged() {
        double sumPrice = 0.0;
        for (Passenger actual : passengers) {
            sumPrice += getPriceForPassenger(actual);
        }
        return sumPrice;
    }

    public Map<CruiseClass, Integer> countPassengerByClass() {
        Map<CruiseClass, Integer> statistics = new HashMap<>();
        for (Passenger actual : passengers) {
            if (!statistics.containsKey(actual.getCruiseClass())) {
                statistics.put(actual.getCruiseClass(), 0);
            }
            statistics.put(actual.getCruiseClass(), statistics.get(actual.getCruiseClass()) + 1);
        }
        return statistics;
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        List<Passenger> result = new ArrayList<>();
        for (Passenger actual : passengers) {
            result.add(new Passenger(actual));
        }
        return result;
    }
}
