package week05d05;

import org.junit.jupiter.api.Test;
import stringconcat.employee.Employee;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testUserWithWrongEmail() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new User("Jane", "Doe", "janedoe@emailcom"));
        assertEquals("Email is not valid!", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> new User("Jill", "Doe", "jilldoevemail.com"));
        assertEquals("Email is not valid!", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> new User("Jill", "Doe", "@jilldoevemail.com"));
        assertEquals("Email is not valid!", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> new User("Jill", "Doe", ".@jilldoevemailcom"));
        assertEquals("Email is not valid!", ex.getMessage());
    }

    @Test
    public void testGetFullName() {

        assertEquals("Jane Doe", new User("Jane", "Doe", "janedoe@mail.com").getFullName());
    }
}
