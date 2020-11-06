package finalmodifier;

public class CylinderCalculatorBasedOnCircle {

    CircleCalculator circCalc = new CircleCalculator();

    public double calculateVolume(double r, double h) {
        //return CircleCalculator.PI * (r * r) * h;
        return circCalc.calculateArea(r) * h;
    }


    public double calculateSurfaceArea(double r, double h) {
        //return CircleCalculator.PI * 2 * r * (r + h);
        return (circCalc.calculatePerimeter(r) * h)+ (2 * circCalc.calculateArea(r));
    }


}
