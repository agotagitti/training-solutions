package week05d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StoreTest {

    @Test
    public void testGetNumberOfExpired() {
        Store store = new Store();

        store.addProduct(new Product("alma", 2020, 11, 25));
        store.addProduct(new Product("körte", 2020, 11, 26));
        store.addProduct(new Product("banán", 2021, 11, 25));
        store.addProduct(new Product("narancs", 1900, 11, 25));

        assertEquals(0, store.getNumberOfExpired());
    }

    @Test
    public void testAddProduct() {
        Store store = new Store();

        assertFalse(store.addProduct(new Product("alma", 2020, 11, 25)));
        assertTrue(store.addProduct(new Product("körte", 2020, 11, 26)));
        assertTrue(store.addProduct(new Product("banán", 2021, 11, 25)));
        assertFalse(store.addProduct(new Product("banán", 2021, 11, 25)));
        assertFalse(store.addProduct(new Product("narancs", 1900, 11, 25)));


    }

}
