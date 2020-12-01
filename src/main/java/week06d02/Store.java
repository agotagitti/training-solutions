package week06d02;

import java.util.List;

public class Store {

    List<Product> products;

    public Store(List<Product> products) {
        this.products = products;
    }

    public int getProductByCategory(Category category) {
        int counter = 0;
        for (Product actual: products) {
            if (actual.getCategory() == category) {
                counter++;
            }
        }
        return counter;
    }

}
