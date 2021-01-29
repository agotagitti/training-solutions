package week13d02;

import java.time.LocalTime;

public class Airplane {

    private String flightNumber;
    private Bound arrivalDeparture;
    private String destination;
    private LocalTime time;

    public Airplane(String flightNumber, Bound arrivalDeparture, String destination, LocalTime time) {
        this.flightNumber = flightNumber;
        this.arrivalDeparture = arrivalDeparture;
        this.destination = destination;
        this.time = time;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Bound getArrivalDeparture() {
        return arrivalDeparture;
    }

    public String getDestination() {
        return destination;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Airplane: " + flightNumber + ", " + arrivalDeparture + ", " + destination + ", " + time;
    }
}
