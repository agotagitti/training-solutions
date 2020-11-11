package introunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GentlemanTest {

    @Test
    public void testSayHello() {

        Gentleman gentleman = new Gentleman();

        String hello1 = gentleman.sayHello("John Doe");
        String hello2 = gentleman.sayHello(null);

        assertEquals("Hello John Doe", hello1);
        assertEquals("Hello Anonymous", hello2);
    }


}
