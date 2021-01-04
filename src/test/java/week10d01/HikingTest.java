package week10d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HikingTest {

    @Test
    public void testGetPlusElevation() {
        List<GPS> gpsList = Arrays.asList(
                new GPS(1,2,10),
                new GPS(2,3,20),
                new GPS(3,4,15),
                new GPS(4,5,18)
        );

        Hiking hiking = new Hiking(gpsList);
        assertEquals(13.0, hiking.getPlusElevation(hiking.getAltitudes()));

    }

}
