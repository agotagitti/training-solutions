package attributes.bill;

import java.util.ArrayList;
import java.util.Arrays;

public class BillMain {

    public static void main(String[] args) {
        Bill bill = new Bill();
        bill.addItem(new Item("Cuke", 100, 50));
        bill.addItem(new Item("celery", 20, 200));
        bill.addItem(new Item("coffee beans", 15, 450));
        bill.addItem(new Item("Guinness", 70, 5.9));
        bill.addItem(new Item("Kerrygold", 1, 500));

        for (Item item: bill.getItems()) {
            System.out.println(item.getProduct() + " " + item.getQuantity() + ", " + item.getPrice());
        }

        System.out.println("Bill total is: " + bill.calculateTotalPrice());


    }
}
