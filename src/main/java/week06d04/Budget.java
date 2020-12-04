package week06d04;

import java.util.ArrayList;
import java.util.List;

public class Budget {

    private List<Item> items;

    public Budget(List<Item> items) {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("No items in the list");
        }
        for (Item actual: items) {
            if (actual == null) {
                throw new IllegalArgumentException("Null element found in the list");
            }
        }
        this.items = items;
    }

    public List<Item> getItemsByMonth(int month) {
        List<Item> result = new ArrayList<>();
        for (Item actual: items) {
            if (actual.getMonth() == month) {
                result.add(actual);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(100, 1, "alma"));
        items.add(new Item(150, 3, "körte"));
        items.add(new Item(200, 6, "cseresznye"));
        items.add(new Item(1000, 4, "ananász"));
        items.add(new Item(900, 3, "grapefruit"));
        items.add(new Item(1500, 6, "datolya"));
        items.add(new Item(500, 4, "szőlő"));

        Budget budget = new Budget(items);

        System.out.println(budget.getItemsByMonth(1));


    }
}
