package isahasa.fleet;

public class CanCarryGoodsBehaviour implements CanCarryGoods {

    private int cargoWeight;
    private int maxCargoWeight;

    public CanCarryGoodsBehaviour(int maxCargoWeight) {
        this.maxCargoWeight = maxCargoWeight;
    }

    @Override
    public int loadCargo(int cargoWeight) {
        int notLoaded = maxCargoWeight - this.cargoWeight - cargoWeight;
        if (notLoaded < 0) {
            notLoaded = Math.abs(notLoaded);
            this.cargoWeight = maxCargoWeight;
        } else {
            notLoaded = 0;
            this.cargoWeight += cargoWeight;
        }
        return notLoaded;
    }

    @Override
    public int getCargoWeight() {
        return cargoWeight;
    }

    public int getMaxCargoWeight() {
        return maxCargoWeight;
    }
}
