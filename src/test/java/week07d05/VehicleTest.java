package week07d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleTest {

    @Test
    public void testVehicle() {
        Vehicle vehicle = new Vehicle();
        Car car = new Car();
        Truck truck = new Truck();
        Motorcycle motorcycle = new Motorcycle();

        assertEquals(TransmissionType.MANUAL, vehicle.getTransmissionType());
        assertEquals(TransmissionType.AUTOMATIC, car.getTransmissionType());
        assertEquals(TransmissionType.MANUAL, truck.getTransmissionType());
        assertEquals(TransmissionType.SEQUENTIAL, motorcycle.getTransmissionType());
        assertEquals(5, motorcycle.getNumberOfGears());


    }

}
