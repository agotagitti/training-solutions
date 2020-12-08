package methodparam.measuring;

public class Measurement {

   private double[] values;

    public Measurement(double[] values) {
        this.values = values;
    }

    public int findFirstIndexInLimit(int lower, int upper) {
        int firstInLimit = -1;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > lower && values[i] < upper) {
                firstInLimit = i;
                break;
            }
        }
        return firstInLimit;
    }

    public double minimum() {
        double min = 0.0;
        for (int i = 0; i < values.length; i++) {
            if (min == 0.0 || values[i] < min) {
                min = values[i];
            }
        }
        return min;
    }

    public double maximum() {
        double max = 0.0;
        for (int i = 0; i < values.length; i++) {
            if (max == 0.0 || values[i] > max) {
                max = values[i];
            }
        }
        return max;
    }

    public ExtremValues minmax() {
        return new ExtremValues(minimum(), maximum());
    }

}
