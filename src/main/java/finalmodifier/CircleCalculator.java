package finalmodifier;

public class CircleCalculator {

    final static double PI = 3.14;

    public double calculatePerimeter(double r) {
        return PI * 2 * r;
    }

    public double calculateArea(double r) {
        return PI * (r * r);
    }

}
