package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Capsules {

    private List<String> colorList = new ArrayList<>();

    public void addLast(String color) {
        colorList.add(color);
    }

    public void addFirst(String color) {
        colorList.add(0, color);
    }

    public void removeFirst() {
        colorList.remove(0);
    }

    public void removeLast() {
        colorList.remove(colorList.size() - 1);

    }

    public List<String> getColors() {
       return colorList;
    }

    public static void main(String[] args) {
        Capsules test = new Capsules();

        test.addLast("blue");
        test.addLast("green");

        System.out.println(test.getColors());

        test.addFirst("red");
        test.addFirst("yellow");

        System.out.println(test.getColors());

        test.removeFirst();

        System.out.println(test.getColors());

        test.removeLast();

        System.out.println(test.getColors());

        List<String> newColors = test.getColors();

        newColors.clear();

        System.out.println(newColors);
        System.out.println(test.getColors());
    }
}
