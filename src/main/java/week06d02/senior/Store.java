package week06d02.senior;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {

    List<Product> products;

    public Store(List<Product> products) {
        this.products = products;
    }

    public Map<Category, Integer> getProductsByCategory() {
        Map<Category, Integer> productsByCategory = new HashMap<>();
        for (Product actualProduct : products) {
            if (!productsByCategory.containsKey(actualProduct.getCategory())) {
                productsByCategory.put(actualProduct.getCategory(), 1);
            } else {
                productsByCategory.put(actualProduct.getCategory(), productsByCategory.get(actualProduct.getCategory()) + 1);
            }
        }
        return productsByCategory;
    }

}
