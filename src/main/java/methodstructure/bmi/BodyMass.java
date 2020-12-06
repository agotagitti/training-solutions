package methodstructure.bmi;

public class BodyMass {

    private double weight;
    private double height;

    public BodyMass(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double bodyMassIndex() {
        return weight / (height * height);
    }

    public BmiCategory body() {
        BmiCategory result;
        if (bodyMassIndex() < 18.5) {
            result = BmiCategory.UNDERWEIGHT;
        } else if (bodyMassIndex() > 25) {
            result = BmiCategory.OVERWEIGHT;
        } else {
            result = BmiCategory.NORMAL;
        }
        return result;
    }

    public boolean isThinnerThan(BodyMass newBody) {
       return bodyMassIndex() < newBody.bodyMassIndex();
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

}
