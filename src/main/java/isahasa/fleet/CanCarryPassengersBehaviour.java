package isahasa.fleet;

public class CanCarryPassengersBehaviour implements CanCarryPassengers {

    private int passengers;
    private int maxPassengers;

    public CanCarryPassengersBehaviour(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    @Override
    public int loadPassenger(int passengers) {
        int notLoaded = maxPassengers - this.passengers - passengers;
        if (notLoaded < 0) {
            notLoaded = Math.abs(notLoaded);
            this.passengers = maxPassengers;
        } else {
            notLoaded = 0;
            this.passengers += passengers;
        }
        return notLoaded;
    }

    @Override
    public int getPassengers() {
        return passengers;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }
}
