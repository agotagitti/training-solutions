package finalmodifier;

public class PiMain {

    public static void main(String[] args) {
        CircleCalculator circleCalculator = new CircleCalculator();
        CylinderCalculator cylinderCalculator = new CylinderCalculator();

        System.out.println(circleCalculator.calculatePerimeter(5.0));
        System.out.println(circleCalculator.calculateArea(3.0));

        System.out.println(cylinderCalculator.calculateVolume(2.5, 4.2));
        System.out.println(cylinderCalculator.calculateSurfaceArea(3.8, 1.2));

        System.out.println(CircleCalculator.PI);

    }
}
