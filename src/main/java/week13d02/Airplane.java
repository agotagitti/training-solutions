package week13d02;

public class Airplane {

    private String flightNumber;
    private Bound arrivalDeparture;
    private String destination;
    private String time;

    public Airplane(String flightNumber, Bound arrivalDeparture, String destination, String time) {
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

    public String getTime() {
        return time;
    }
}
