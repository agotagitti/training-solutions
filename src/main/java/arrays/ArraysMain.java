package arrays;

import java.util.Arrays;

public class ArraysMain {

    public String numberOfDaysAsString() {
        int[] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return Arrays.toString(numberOfDays);
    }

    public String multiplicationTableAsString(int size) {
        int[][] multi = new int[size][size];
        for (int i =0; i < multi.length; i++) {
            for (int j = 0; j < multi[i].length; j++) {
                multi[i][j] = (i + 1) * (j + 1);
            }
        } return Arrays.deepToString(multi);
    }

    public boolean sameTempValues(double[] day, double[] anotherDay) {
        return Arrays.equals(day, anotherDay);
    }

    public boolean wonLottery(int[] numbers, int[] winner) {
        int[] numbers2 = Arrays.copyOf(numbers, numbers.length);
        int[] winner2 = Arrays.copyOf(winner, numbers.length);
        Arrays.sort(numbers2);
        Arrays.sort(winner2);

        return Arrays.equals(numbers2, winner2);
    }

    public int min(int value1, int value2) {
        return (value1 <= value2) ? value1 : value2;
    }

    public boolean sameTempValuesDaylight(double[] day, double[] anotherDay) {
        int minLength = min(day.length, anotherDay.length);
        return Arrays.equals(Arrays.copyOfRange(day, 0, minLength), Arrays.copyOfRange(anotherDay, 0, minLength));
    }


    public static void main(String[] args) {
        ArraysMain test = new ArraysMain();

        double[] day1 = {10.0, 12, 14, 16, 18};
        double[] day2 = {10.0, 12, 14, 16, 18};
        double[] day3 = {10, 12, 13.0, 16, 18};
        double[] day4 = {10, 12, 13.0, 16, 18, 20, 22};
        double[] day5 = {10, 12, 13.0, 16, 18, 20, 22, 24};

        int[] numbers = {5, 13, 64, 52, 70, 90};
        int[] winner = {5, 13, 52, 46, 90, 70};


        System.out.println(test.numberOfDaysAsString());
        System.out.println(test.multiplicationTableAsString(5));

        System.out.println(test.sameTempValues(day1, day2));
        System.out.println(test.sameTempValues(day1, day3));

        System.out.println(test.wonLottery(numbers,winner));
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(winner));

        System.out.println(test.sameTempValuesDaylight(day5, day4));

    }
}
