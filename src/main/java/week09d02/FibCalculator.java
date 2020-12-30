package week09d02;

public class FibCalculator {

    public long sumEvens(int bound) {
         return sumEvensRecursive(0, 1, bound);
    }

    private long sumEvensRecursive(int number1, int number2, int bound) {
        int actualFibNum = number1 + number2;
        if (number1 + number2 <= bound) {
           return (actualFibNum % 2 == 0 ? actualFibNum : 0)
                           + sumEvensRecursive(number2, number1 + number2, bound);
       } else {
            return 0;
        }
    }

    public long sumEvensLoop(int bound) {
        int prevFibNum1 = 0;
        int prevFibNum2 = 1;
        int actualFibNum = prevFibNum1 + prevFibNum2;
        int sumFibNum = 0;
        while (actualFibNum <= bound) {
            sumFibNum += (actualFibNum % 2 == 0 ? actualFibNum : 0);
            prevFibNum1 = prevFibNum2;
            prevFibNum2 = actualFibNum;
            actualFibNum = prevFibNum1 + prevFibNum2;
        }
        return sumFibNum;
    }
//
//    public static void main(String[] args) {
//        FibCalculator fibCalculator = new FibCalculator();
//
//        System.out.println(fibCalculator.sumEvensLoop(190000));
//    }

}
