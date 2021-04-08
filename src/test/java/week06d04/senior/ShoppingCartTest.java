package week06d04.senior;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    ShoppingCart shoppingCart = new ShoppingCart();

    @BeforeEach
    void setup() {
        shoppingCart.addItem("apple", 5);
        shoppingCart.addItem("bread", 10);
        shoppingCart.addItem("honey", 2);
    }

    @Test
    void testShoppingCart() {
        shoppingCart.addItem("apple", 1);
        assertEquals(6, shoppingCart.getItem("apple"));

        shoppingCart.addItem("milk", 3);
        assertEquals(3, shoppingCart.getItem("milk"));

        assertEquals(0, shoppingCart.getItem("something"));
    }

}