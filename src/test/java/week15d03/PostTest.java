package week15d03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {

    @Test
    public void testExceptionDate() {
        LocalDate later = LocalDate.of(3000, 01, 01);
        LocalDate earlier = LocalDate.of (2000, 01, 01);
        LocalDate now = LocalDate.now();

        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Post("Title1", now, later, "Content1", "Owner1"));
        assertEquals("Invalid publishing date", ex.getMessage());

        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> new Post("Title2", later, later, "Content2", "Owner2"));
        assertEquals("Invalid publishing date", ex2.getMessage());
    }

    @Test
    public void testExceptionEmptyArgument() {
        LocalDate later = LocalDate.of(3000, 01, 01);
        LocalDate earlier = LocalDate.of (2000, 01, 01);
        LocalDate now = LocalDate.now();

        Exception ex3 = assertThrows(IllegalArgumentException.class, () -> new Post("", earlier, later, "Content1", "Owner1"));
        assertEquals("Invalid argument", ex3.getMessage());

        Exception ex4 = assertThrows(IllegalArgumentException.class, () -> new Post("Title4", earlier, later, "", "Owner1"));
        assertEquals("Invalid argument", ex4.getMessage());
    }

}