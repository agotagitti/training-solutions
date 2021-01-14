package exceptions.polinom;

public class Polynomial {

    private double[] coefficients;

    public Polynomial(double[] coefficients) {
        if (coefficients == null) {
            throw new NullPointerException("coefficients is null");
        }
        this.coefficients = coefficients;
    }

    public Polynomial(String[] coefficientStrs) {
        if (coefficientStrs == null) {
            throw new NullPointerException("coefficientStrs is null");
        }
        double[] stringArray = new double[coefficientStrs.length];
            try {

            for (int i = 0; i < coefficientStrs.length; i++) {
                stringArray[i] = Double.parseDouble(coefficientStrs[i]);
            }
        }
        catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Illegal coefficients, not a number", nfe);
        }
        this.coefficients = stringArray;
    }

    public double evaluate(double x) {
        double sum = 0.0;
        for (int i = coefficients.length - 1; i >= 0; i--) {
            sum += coefficients[i] * Math.pow(x, (coefficients.length - 1) - i);
        }
        return sum;
    }

    public double[] getCoefficients() {
        return coefficients;
    }

}
