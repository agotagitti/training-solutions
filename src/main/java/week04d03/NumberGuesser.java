package week04d03;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int randomInt = random.nextInt(100) + 1;
        System.out.println("Guess the number!");
        int guess = scanner.nextInt();



        while(guess != randomInt) {
            if (guess > randomInt) {
                System.out.println("Your guess is higher than our number");
                guess = scanner.nextInt();
            }
            if (guess < randomInt) {
                System.out.println("Your guess is lower than our number");
                guess = scanner.nextInt();
            }
        }

        if (guess == randomInt) {
            System.out.println("You found the number: " + randomInt);
        }

    }




}
