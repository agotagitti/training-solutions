package week07d04;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


public class LabTest {

    @Test
    public void testComplete() {
        Lab lab1 = new Lab("First");
        Lab lab2 = new Lab("Second", LocalDate.of(2020, 12, 05));

        assertFalse(lab1.isCompleted());
        assertTrue(lab2.isCompleted());

        lab1.complete(LocalDate.of(2020,10,01));
        assertEquals("Title= First, completed= true, completedAt= 2020-10-01", lab1.toString());

        lab2.complete();
        assertEquals(LocalDate.now(), lab2.getCompletedAt());
    }

}
