package inheritanceconstructor.cars;

public class Car {

    private double fuelRate; //? l/100km
    private double fuel;
    private double tankCapacity;

    public Car(double fuelRate, double fuel, double tankCapacity) {
        this.fuelRate = fuelRate;
        this.fuel = fuel;
        if (fuel > tankCapacity) {
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        this.tankCapacity = tankCapacity;
    }

    public void modifyFuelAmount(double fuel) {
        this.fuel += fuel;
    }

    public void drive(int km) {
        if (!enoughFuel(km)) {
            throw new RuntimeException("Not enough fuel available!");
        }
        modifyFuelAmount((fuelRate * km / 100) * -1);
    }

    public double calculateRefillAmount() {
        return tankCapacity - fuel;
    }

    public double getFuel() {
        return fuel;
    }

    public double getFuelRate() {
        return fuelRate;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    private boolean enoughFuel(int km) {
        return (fuel - fuelRate * km / 100) > 0;
    }

}
