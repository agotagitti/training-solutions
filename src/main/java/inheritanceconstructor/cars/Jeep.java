package inheritanceconstructor.cars;

public class Jeep extends Car{

    private double extraCapacity;
    private double extraFuel;

    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
        super(fuelRate, fuel, tankCapacity);
        if (fuel > tankCapacity) {
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        this.extraCapacity = extraCapacity;
        this.extraFuel = extraFuel;
    }

    @Override
    public void modifyFuelAmount(double fuel) {
        if (extraFuel < Math.abs(fuel)) {
            super.modifyFuelAmount((Math.abs(fuel) - extraFuel) * Math.signum(fuel));
            extraFuel = 0;
        } else {
            extraFuel += fuel;
        }
    }

    @Override
    public void drive(int km) {
        if (!enoughFuel(km)) {
            throw new RuntimeException("Not enough fuel available!");
        }
        modifyFuelAmount((getFuelRate() * km / 100) * -1);
    }

    @Override
    public double calculateRefillAmount() {
        return (getTankCapacity() + extraCapacity) - (getFuel() + extraFuel);
    }

    private boolean enoughFuel(int km) {
        return (extraFuel + getFuel()) - getFuelRate() * km / 100 > 0;
    }

    public double getExtraCapacity() {
        return extraCapacity;
    }

    public double getExtraFuel() {
        return extraFuel;
    }
}
