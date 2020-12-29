package isahasa.fleet;

public class FerryBoat implements Ship, CanCarryPassengers, CanCarryGoods {

    private CanCarryPassengers canCarryPassengers;
    private CanCarryGoods canCarryGoods;

    public FerryBoat(int cargoWeight, int passenger) {
        canCarryPassengers = new CanCarryPassengersBehaviour(passenger);
        canCarryGoods = new CanCarryGoodsBehaviour(cargoWeight);
    }

    @Override
    public int loadCargo(int cargoWeight) {
        return canCarryGoods.loadCargo(cargoWeight);
    }

    @Override
    public int getCargoWeight() {
        return canCarryGoods.getCargoWeight();
    }

    @Override
    public int loadPassenger(int passengers) {
        return canCarryPassengers.loadPassenger(passengers);
    }

    @Override
    public int getPassengers() {
        return canCarryPassengers.getPassengers();
    }
}
