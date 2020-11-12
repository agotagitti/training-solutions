package controlselection.month;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DayInMonthTest {

    @Test
    public void testDaysInMonth() {

       assertEquals(29, new DayInMonth().daysInMonth(2000, "február"));
       assertEquals(28, new DayInMonth().daysInMonth(1900, "február"));
       assertEquals(30, new DayInMonth().daysInMonth(1986, "április"));
       assertEquals(31, new DayInMonth().daysInMonth(1582, "október"));
    }

    @Test
    public void testIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {new DayInMonth().daysInMonth(2500, "jan");});
    }

}
