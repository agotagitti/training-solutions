package isahasa.fleet;

import java.util.ArrayList;
import java.util.List;

public class Fleet {

    private List<Ship> shipList = new ArrayList<>();
    private int waitingPersons;
    private int waitingCargo;

    public void addShip(Ship ship) {
        shipList.add(ship);
    }

    public void loadShip(int passenger, int cargoWeight) {
        waitingPersons = passenger;
        waitingCargo = cargoWeight;
        for (Ship actual: shipList) {
           if(actual instanceof Liner && waitingPersons > 0) {
               waitingPersons = ((Liner) actual).loadPassenger(waitingPersons);
           } else if (actual instanceof CargoShip && waitingCargo > 0) {
               waitingCargo = ((CargoShip) actual).loadCargo(waitingCargo);
           } else if (actual instanceof FerryBoat) {
               if (waitingPersons > 0) {
                   waitingPersons = ((FerryBoat) actual).loadPassenger(waitingPersons);
               }
               if (waitingCargo > 0) {
                   waitingCargo = ((FerryBoat) actual).loadCargo(waitingCargo);
               }

           }
        }
    }

    public int getWaitingPersons() {
        return waitingPersons;
    }

    public int getWaitingCargo() {
        return waitingCargo;
    }
}
