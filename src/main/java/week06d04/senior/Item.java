package week06d04.senior;

public class Item {

    private String name;

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private int quantity;

    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

}
