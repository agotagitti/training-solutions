package statements;

import java.util.Scanner;

public class DivByThree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me a whole number!");
        int number = scanner.nextInt();

        System.out.println("Can divide by 3: " + (number % 3 == 0 ? true : false));


    }

}
