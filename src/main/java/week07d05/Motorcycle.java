package week07d05;

public class Motorcycle extends Vehicle{

    @Override
    public TransmissionType getTransmissionType() {
        return TransmissionType.SEQUENTIAL;
    }

}
