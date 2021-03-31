package week06d02.senior;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    @Test
    void testGetProductsByCategory() {
        List<Product> productList = List.of(
                new Product("milk", Category.DAIRY, 300),
                new Product("butter", Category.DAIRY, 600),
                new Product("cream", Category.DAIRY, 400),
                new Product("beans", Category.FROZEN, 500),
                new Product("icecream", Category.FROZEN, 2000),
                new Product("bread", Category.BAKEDGOODS, 700),
                new Product("cake", Category.BAKEDGOODS, 3000),
                new Product("gum", Category.OTHER, 200));

        Store store = new Store(productList);
        assertEquals(3, store.getProductsByCategory().get(Category.DAIRY));
        assertEquals(1, store.getProductsByCategory().get(Category.OTHER));


    }
}