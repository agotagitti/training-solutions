package introconstructors;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private List<String> menu = new ArrayList<>();
    private String name;
    private int capacity;

    public Restaurant(String name, int capacity) {
        this.name = name;
        this.capacity = capacity * 4;
        menuItems("Stew");
        menuItems("Steak");
        menuItems("Pie");
    }

    public void menuItems(String item) {
        menu.add(item);
    }

    public List<String> getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

}
