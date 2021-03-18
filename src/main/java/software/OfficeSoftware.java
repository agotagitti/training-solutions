package software;

public class OfficeSoftware extends Software {

    public OfficeSoftware(String name, double price) {
        super(name, price);
    }

    @Override
    public void increasePrice() {
        this.price = super.getPrice() * 1.05;
    }

}
