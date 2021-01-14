package week11d02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CourierTest {

    @Test
    public void testCourier(){

        Courier courier = new Courier();
        courier.addRide(new Ride(1,1,1));
        courier.addRide(new Ride(2,1,1));
        courier.addRide(new Ride(3,1,1));
        courier.addRide(new Ride(5,1,1));
        courier.addRide(new Ride(6,1,1));

        assertEquals(4,courier.getEarliestHoliday());

    }
    @Test
    void addRideIsNull() {
        Courier courier = new Courier(List.of(new Ride(1, 1, 1)));
        Exception actualException = assertThrows(IllegalArgumentException.class, () -> {
            courier.addRide(null);
        });
        assertEquals("No ride", actualException.getMessage());

    }

    @Test
    void addFirstRide() {
        List<Ride> list = new ArrayList<>();
        Courier courier = new Courier(list);
        Ride ride = new Ride(1, 1, 1);
        courier.addRide(ride);
        assertEquals(1, courier.getRides().size());
    }


    @Test
    void addFirstRideError() {
        List<Ride> list = new ArrayList<>();
        Courier courier = new Courier(list);
        Ride ride = new Ride(1, 2, 1);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            courier.addRide(ride);
        });
        assertEquals("Invalid ride number", ex.getMessage());
    }


    @Test
    void freeDay() {
        Courier courier = new Courier(List.of(new Ride(1, 1, 1),
                new Ride(1, 2, 3),
                new Ride(3, 1, 1)
        ));

        assertEquals(2, courier.getEarliestHoliday());

    }

    @Test
    void addRideDayIsDifferent() {
        List<Ride> list = new ArrayList<>();
        Courier courier = new Courier(list);
        Ride ride = new Ride(1, 1, 1);
        courier.addRide(ride);
        Ride ride2 = new Ride(2, 1, 1);
        courier.addRide(ride2);
        assertEquals(2, courier.getRides().size());
    }

    @Test
    void addRideDayIsSame() {
        List<Ride> list = new ArrayList<>();
        Courier courier = new Courier(list);
        Ride ride = new Ride(1, 1, 1);
        courier.addRide(ride);
        Ride ride2 = new Ride(1, 2, 1);
        courier.addRide(ride2);
        assertEquals(2, courier.getRides().size());
    }


    @Test
    void addRideDayInNotOrder() {
        List<Ride> list = new ArrayList<>();
        Courier courier = new Courier(list);
        Ride ride = new Ride(1, 1, 1);
        courier.addRide(ride);
        Ride ride2 = new Ride(3, 2, 1);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            courier.addRide(ride2);
        });
        assertEquals("Invalid ride number", ex.getMessage());

    }

}