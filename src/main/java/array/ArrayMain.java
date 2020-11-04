package array;

import org.w3c.dom.ls.LSOutput;

public class ArrayMain {

    public static void main(String[] args) {

        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        System.out.println(daysOfWeek[1]);
        System.out.println("Days of Week: " + daysOfWeek.length);

        int[] powerOfTwo = new int[5];
        int number = 1;

        for (int i =0; i < powerOfTwo.length; i++) {
            powerOfTwo[i] = number;
            number = number * 2;
        }

        for (int item: powerOfTwo) {
            System.out.println(item);
        }

        boolean[] trueOrFalse = new boolean[6];
        boolean value = false;

        for (int i = 0; i < trueOrFalse.length; i++) {
            trueOrFalse[i] = value;
            value = !value;
        }

        for (boolean item: trueOrFalse) {
            System.out.println(item);
        }
    }
}
