package week11d02;

public class Ride {

    private int dayNumber;
    private int rideNumber;
    private double km;

    public Ride(int dayNumber, int rideNumber, double km) {
        //day number
        this.dayNumber = dayNumber;
        this.rideNumber = rideNumber;
        if (km == 0.0) {
            throw new IllegalArgumentException("Invalid km");
        }
        this.km = km;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public int getRideNumber() {
        return rideNumber;
    }

    public double getKm() {
        return km;
    }
}
