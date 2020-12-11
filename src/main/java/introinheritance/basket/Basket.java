package introinheritance.basket;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(String barcode) {
        Item toRemove = null;
        for (Item actual: items) {
            if (actual.getBarcode().equals(barcode)) {
                toRemove = actual;
            }
        }
        items.remove(toRemove);
    }

    public void clearBasket() {
        items.clear();
    }

    public List<Item> getItems () {
        return new ArrayList<>(items);
    }

}
