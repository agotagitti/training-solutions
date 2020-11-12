package controlselection.greeting;

import controlselection.greetings.Greetings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingsTest {

    @Test
    public void testSayGreeting() {
        Greetings greetings = new Greetings();

        assertEquals("Good Night", greetings.sayGreeting(3, 30));
        assertEquals("Good Night", greetings.sayGreeting(4, 59));
        assertEquals("Good Night", greetings.sayGreeting(0, 1));
        assertEquals("Good Night", greetings.sayGreeting(20, 1));
        assertEquals("Good Morning", greetings.sayGreeting(5, 1));
        assertEquals("Good Morning", greetings.sayGreeting(8, 59));
        assertEquals("Good Afternoon", greetings.sayGreeting(9, 0));
        assertEquals("Good Afternoon", greetings.sayGreeting(17, 50));
        assertEquals("Good Afternoon", greetings.sayGreeting(18, 29));
        assertEquals("Good Evening", greetings.sayGreeting(18, 31));
        assertEquals("Good Evening", greetings.sayGreeting(19, 59));
    }

}
