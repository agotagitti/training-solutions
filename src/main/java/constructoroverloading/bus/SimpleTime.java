package constructoroverloading.bus;

public class SimpleTime {

    private int hours;
    private int minutes;

    public SimpleTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public SimpleTime(int hours) {
        this(hours, 0);
    }

    public SimpleTime(SimpleTime time) {
        this(time.getHours(), time.getMinutes());

    }

    public int difference(SimpleTime time) {
        return (this.hours * 60 + this.minutes) - (time.getHours() * 60 + time.getMinutes());
    }

    @Override
    public String toString() {
        //"15:16"
        return hours + ":" + minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }
}
