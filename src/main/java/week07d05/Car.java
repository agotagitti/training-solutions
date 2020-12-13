package week07d05;

public class Car extends Vehicle {

    @Override
    public TransmissionType getTransmissionType() {
        return TransmissionType.AUTOMATIC;
    }

}
