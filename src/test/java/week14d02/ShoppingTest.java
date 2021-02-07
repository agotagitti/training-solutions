package week14d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingTest {

    Shopping shopping = new Shopping();
    Path path = Path.of("src/main/resources/shopping_list.txt");
    @BeforeEach
    void setUp() {
        shopping.readFile(path);
    }


    @Test
    void getItemsById() {
        List<String> result = shopping.getItemsById("B3402");
        assertEquals(List.of("bbq_sauce", "cola", "meet", "soda"), result);
    }

    @Test
    void getReverseItemsById() {

        List<String> resultReverse = shopping.getReverseItemsById("B3402");
        assertEquals(List.of("soda","meet","cola","bbq_sauce"), resultReverse);
    }

    @Test
    void getSaleNumberByItem() {
        int resultCount = shopping.getSaleNumberByItem("tomato");
        assertEquals(2, resultCount);
    }

    @Test
    void getNumberOfItemsById() {
        int sizeList = shopping.getNumberOfItemsById("B3402");
        assertEquals(4, sizeList);
    }

    @Test
    void getStatistics() {
        Map<String, Integer> resultMap = shopping.getStatistics();
        assertEquals(2, resultMap.get("rosmary").intValue());

    }


}