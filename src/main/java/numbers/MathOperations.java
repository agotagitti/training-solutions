package numbers;

import java.util.Scanner;

public class MathOperations {

    public static void main(String[] args) {

        System.out.println("(5 - 1) / 2 + 3.5 * 9");
        double result = (5 - 1) / 2 + 3.5 * 9;
        System.out.println("What is the result?");

        Scanner scanner = new Scanner(System.in);
        double isResult = scanner.nextDouble();

        if (Math.abs(result - isResult) < 0.0001) {
            System.out.println("Your result is right");
        } else {
            System.out.println("Your result is wrong");
        }

    }
}
