package statements;

import java.util.Scanner;

public class TimeMain {

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        System.out.println("First hours:");
        int hour = scanner.nextInt();
        System.out.println("First minutes:");
        int min = scanner.nextInt();
        System.out.println("First seconds:");
        int sec = scanner.nextInt();

        Time time = new Time(hour,min,sec);

        //a time object-ben eltároltam az attribútumok értékét, ezért ezek az attribútumok kaphatnak új értéket
        System.out.println("Second hours:");
        hour = scanner.nextInt();
        System.out.println("Second minutes:");
        min = scanner.nextInt();
        System.out.println("Second minutes:");
        sec = scanner.nextInt();
        Time anotherTime = new Time(hour, min, sec);

        System.out.println("First time: " + time.toString() + " = " + time.getInMinutes());
        System.out.println("Second time: " + anotherTime.toString() + " = " + anotherTime.getInSeconds());
        System.out.println("The first time is earlier than the second: " + time.earlierThan(anotherTime));

    }
}
