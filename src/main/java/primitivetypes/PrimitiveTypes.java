package primitivetypes;

public class PrimitiveTypes {

    public static final int BIT_LENGTH = 32;

    public String toBinaryString(int n) {
        String x = "";
        for (int i = n; i > 0; i /= 2) {
            x = (i % 2) + x;
        }

        if (x.length() < BIT_LENGTH) {
            int xLength = BIT_LENGTH - x.length();
            for (int j = 0; j < xLength; j++) {
                x = "0" + x;
            }
        }
        return x;
    }

}
