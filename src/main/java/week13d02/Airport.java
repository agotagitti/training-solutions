package week13d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Airport {

    List<Airplane> airplanes = new ArrayList<>();

    public void loadAirplanesFromFile() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                Airport.class.getResourceAsStream("/cities.txt")))) {
            String line;
            while ((line = br.readLine()) != null) {
                airplanes.add(splitAirplaneData(line));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    private Airplane splitAirplaneData(String line) {
        String[] airplaneData = line.split(" ");
        Bound bound = Bound.DEPARTURE;
        if (airplaneData[1].equalsIgnoreCase(Bound.ARRIVAL.toString())) {
            bound = Bound.ARRIVAL;
        }
        String[] time = airplaneData[3].split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        LocalTime airplaneTime = LocalTime.of(hour, minute);
        return new Airplane(airplaneData[0], bound, airplaneData[2], airplaneTime);
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
            if (actual.getDestination().equalsIgnoreCase(city) && actual.getArrivalDeparture() == arrivalDeparture) {
                foundAirplanes.add(actual);
            }
        }
        return foundAirplanes;
    }

    public Airplane earliestAirplane() {
        LocalTime time = LocalTime.of(23, 59);
        Airplane earliest = airplanes.get(0);
        for (Airplane actual: airplanes) {
            if (actual.getTime().isBefore(time) && actual.getArrivalDeparture().equals(Bound.DEPARTURE)) {
                time = actual.getTime();
                earliest = actual;
            }
        }
        return earliest;
    }

    public static void main(String[] args) {
        Airport airport = new Airport();
        airport.loadAirplanesFromFile();
        System.out.println(airport.airplanes.size());

        System.out.println(airport.getMoreArrivalOrDeparture());

        System.out.println(airport.getAirplaneByNumber("PN4148"));
//        System.out.println(airport.getAirplaneByNumber("ABC123"));

        System.out.println(airport.getAirplanesWithSameDestination("Wien", Bound.DEPARTURE));
        System.out.println(airport.getAirplanesWithSameDestination("london", Bound.ARRIVAL));

        System.out.println(airport.earliestAirplane());

    }

}
