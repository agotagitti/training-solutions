package week11d01;

public class DivisorFinder {

    public int findDivisor(int n) {
        int counter = 0;
        int number = n;
        while (number > 0) {
            if ((number % 10 != 0) && (n % (number % 10) == 0)) {
                counter++;
            }
            number /= 10;
        }
        return counter;
    }

}
