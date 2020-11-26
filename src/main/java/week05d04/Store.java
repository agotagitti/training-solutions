package week05d04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Product> products = new ArrayList<>();

    public boolean addProduct(Product newProduct) {
        boolean foundProduct = false;
        boolean result = false;
        if (!newProduct.getShelfLife().isBefore(LocalDate.now())) {
            for (Product actual: products) {
                if (actual.getName().equals(newProduct.getName())) {
                    foundProduct = true;
                    break;
                }
            }
            if (!foundProduct) {
                products.add(newProduct);
                result = true;
            }
        }
      return result;
    }

    public int getNumberOfExpired() {
        int counter = 0;
        for (Product actual: products) {
            if (actual.getShelfLife().isBefore(LocalDate.now())) {
                counter++;
            }
        }
        return counter;
    }

}
