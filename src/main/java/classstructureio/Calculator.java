package classstructureio;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give me a number, please.");
        int numberOne = scanner.nextInt();
        System.out.println("Give me a second number, please.");
        int numberTwo = scanner.nextInt();
        System.out.println(numberOne + " + " + numberTwo);
        System.out.println(numberOne + numberTwo);

    }

}
