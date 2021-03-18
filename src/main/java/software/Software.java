package software;

public abstract class Software {

    private String name;
    double price;

    public Software(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract void increasePrice();

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
