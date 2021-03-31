package week05d04.senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void convertPrice() {
        Product product = new Product(150, "huf");
        Product product2 = new Product(23, "usd");

        assertEquals(0.5, product.convertPrice("usd"));
        assertEquals(6900.0, product2.convertPrice("huf"));


    }
}