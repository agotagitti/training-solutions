package week07d01.senior;

public class Fibonacci {

    public long fib(int n) {
        if (n <= 1) {
            return n;
        }
        int fib1 = 0;
        int fib2 = 1;
        int fibTemp = 0;
        for (int i = 1; i < n; i++) {
            fibTemp = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibTemp;
        }
        return fib2;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fib(0));
        System.out.println(fibonacci.fib(1));
        System.out.println(fibonacci.fib(5));
        System.out.println(fibonacci.fib(10));
        System.out.println(fibonacci.fib(14));
    }

}
