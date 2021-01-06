package week10d02;

import org.junit.jupiter.api.Test;
import weekd10d02.MaxTravel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxTravelTest {

    @Test
    public void testGetMaxIndex() {
        MaxTravel maxTravel = new MaxTravel();
        assertEquals(4, maxTravel.getMaxIndex(List.of(12,12,0,3,4,4)));
    }

}
