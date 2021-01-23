package ioreadwritebytes.temperatures;

public class Temperatures {

    private byte[] data;

    public Temperatures(byte[] data) {
        this.data = data;
    }

    public double getYearAverage() {
        int sum = 0;
        for (byte actual: data) {
            sum += actual;
        }
        return sum / 365.0;
    }

    public double getMonthAverage() {
        int sum = 0;
        for (int i = data.length - 30; i < data.length; i++) {
            sum += data[i];
        }
        return sum / 30.0;
    }

    public byte[] getData() {
        return data;
    }
}
