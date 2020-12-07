package week07d01;

public class MathAlgorithms {

    public static boolean isPrime(int x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Parameter cannot be zero or less!");
        }
        boolean prime = true;
        if (x == 1) {
            prime = false;
        }
        for (int i = 2; i <= x / 2; i++) {
            if (x % i == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }

}
