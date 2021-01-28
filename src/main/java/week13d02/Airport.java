package week13d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Airport {

    List<Airplane> airplanes = new ArrayList<>();

    public void loadAirplanesFromFile() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                Airport.class.getResourceAsStream("/cities.txt")))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] airplaneData = line.split(" ");
                Bound bound = Bound.DEPARTURE;
                if (airplaneData[1].equalsIgnoreCase(Bound.ARRIVAL.toString())) {
                    bound = Bound.ARRIVAL;
                }
                airplanes.add(new Airplane(airplaneData[0], bound, airplaneData[2], airplaneData[3]));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    public String getMoreArrivalOrDeparture() {
        int countArrival = 0;
        for (Airplane actual: airplanes) {
            if (actual.getArrivalDeparture() == Bound.ARRIVAL) {
                countArrival++;
            }
        }
        return countArrival > airplanes.size() / 2 ? Bound.ARRIVAL.toString() : Bound.DEPARTURE.toString();
    }

    public Airplane getAirplaneByNumber(String flightNumber) {
        for (Airplane actual: airplanes) {
            if (actual.getFlightNumber().equals(flightNumber)) {
                return actual;
            }
        }
        throw new IllegalArgumentException("Airplane not found");
    }

    public List<Airplane> getAirplanesWithSameDestination(String city, Bound arrivalDeparture) {
        List<Airplane> foundAirplanes = new ArrayList<>();
        for (Airplane actual: airplanes) {
            if (actual.getDestination().equals(city) && actual.getArrivalDeparture() == arrivalDeparture) {
                foundAirplanes.add(actual);
            }
        }
        return foundAirplanes;
    }

    public static void main(String[] args) {


    }

}
