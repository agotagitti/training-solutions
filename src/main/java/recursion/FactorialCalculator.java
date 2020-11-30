package recursion;

public class FactorialCalculator {

    public long getFactorial(int x) {
        if (x > 1) {
            long solution = getFactorial(x-1);
            return x * solution;
        }else {
            return 1;
        }
    }
}
