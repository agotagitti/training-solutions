package week06d02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    public void testStore() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("alma", Category.OTHER, 100));
        products.add(new Product("borsó", Category.FROZEN, 100));
        products.add(new Product("vaj", Category.DAIRY, 100));
        products.add(new Product("füge", Category.OTHER, 100));
        products.add(new Product("zsemle", Category.BAKEDGOODS, 100));
        products.add(new Product("tej", Category.DAIRY, 100));

        Store store = new Store(products);

        assertEquals(2, store.getProductByCategory(Category.DAIRY));
        assertEquals(1, store.getProductByCategory(Category.FROZEN));

    }
}
