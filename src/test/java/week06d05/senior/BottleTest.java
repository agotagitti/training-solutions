package week06d05.senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BottleTest {

    @Test
    void testBottle() {
        Bottle bottle = new Bottle(BottleType.PET_BOTTLE, 3);
        Bottle bottle2 = Bottle.of(BottleType.GLASS_BOTTLE);

        assertEquals(3, bottle.getFilledUntil());

        assertEquals(10, bottle2.getType().getMaximumAmount());
        bottle2.fill(7);
        assertEquals(7, bottle2.getFilledUntil());
    }

}