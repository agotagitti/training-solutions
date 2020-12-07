package methodstructure.pendrives;

public class Pendrive {

    private String name;
    private int capacity;
    private int price;

    public Pendrive(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public void risePrice(int percent) {
        price += (price * percent) / 100;
    }

    public int comparePricePerCapacity(Pendrive otherPendrive) {
        return (int) Math.signum(((double) price / capacity) - ((double) otherPendrive.getPrice() / otherPendrive.capacity));
    }

    public boolean cheaperThan(Pendrive otherPendrive) {
        return price < otherPendrive.getPrice();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Pendrive{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }
}
