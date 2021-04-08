package week06d04.senior;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Item> items = new ArrayList<>();

    public void addItem(String name, int quantity) {
        boolean isItemExist = false;
        for (Item actualItem : items) {
            if (actualItem.getName().equals(name)) {
                actualItem.setQuantity(actualItem.getQuantity() + quantity);
                isItemExist = true;
            }
        }
        if (!isItemExist) {
            items.add(new Item(name, quantity));
        }
    }

    public int getItem(String name) {
        for (Item actualItem : items) {
            if (actualItem.getName().equals(name)) {
                return actualItem.getQuantity();
            }
        }
        return 0;
    }

}
