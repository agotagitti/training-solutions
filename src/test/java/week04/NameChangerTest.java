package week04;

import org.junit.jupiter.api.Test;
import week04d01.NameChanger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameChangerTest {

    @Test
    public void testChangeName() {

        NameChanger nameChanger = new NameChanger("John Doe");

        nameChanger.changeFirstName("Jack");

        assertEquals("Jack Doe", nameChanger.getFullname());
    }

}
