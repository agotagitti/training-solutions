package exam03;

public class Passenger{

    private String name;
    private CruiseClass cruiseClass;

    public Passenger(String name, CruiseClass cruiseClass) {
        this.name = name;
        this.cruiseClass = cruiseClass;
    }

    public Passenger(Passenger otherPassenger) {
        this.name = otherPassenger.name;
        this.cruiseClass = otherPassenger.cruiseClass;
    }

    public String getName() {
        return name;
    }

    public CruiseClass getCruiseClass() {
        return cruiseClass;
    }

}
