package software;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OfficeSoftwareTest {

    @Test
    void increasePrice() {
        Software software = new OfficeSoftware("a", 100.0);
        software.increasePrice();
        assertEquals(105, software.getPrice());
        assertEquals(105, software.price);

        OfficeSoftware officeSoftware = new OfficeSoftware("b", 200);
        officeSoftware.increasePrice();
        assertEquals(210, officeSoftware.getPrice());
    }
}