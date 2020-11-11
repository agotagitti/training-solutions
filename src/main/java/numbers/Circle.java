package numbers;

public class Circle {

    private int diameter;
    private double pi;

    public Circle(int diameter) {
        this.diameter = diameter;
        pi = 3.14;
    }

    public double perimeter() {
        return pi * diameter;
    }

    public double area() {
        return pi * diameter * diameter / 4;
    }
}
