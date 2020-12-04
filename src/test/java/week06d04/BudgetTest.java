package week06d04;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BudgetTest {

    @Test
    public void testGetItemsByMonth() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(100, 1, "alma"));
        items.add(new Item(150, 3, "körte"));
        items.add(new Item(200, 6, "cseresznye"));
        items.add(new Item(1000, 4, "ananász"));
        items.add(new Item(900, 11, "grapefruit"));
        items.add(new Item(1500, 6, "datolya"));
        items.add(new Item(500, 4, "szőlő"));

        Budget budget = new Budget(items);

        assertEquals(2, budget.getItemsByMonth(6).size());
        assertEquals("[Item name: alma, price: 100, month: 1]", budget.getItemsByMonth(1).toString());
        assertEquals("szőlő", budget.getItemsByMonth(4).get(1).getName());

    }
}
