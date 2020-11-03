package introcontrol;

import java.util.Scanner;

public class Sum {

    public static void main(String[] args) {
        System.out.println("Give me 5 numbers");
        Scanner scanner = new Scanner(System.in);
        int number = 0;

        for (int i = 0; i < 5; i++) {
            System.out.println("Give me the next number!");
            number += scanner.nextInt();
        }
        System.out.println(number);
    }

}
