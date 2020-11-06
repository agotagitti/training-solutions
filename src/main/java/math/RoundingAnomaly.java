package math;

import java.util.Random;

public class RoundingAnomaly {


    public double[] randomNumbers(int size, double max, int scale) {
        double[] randomNumArray = new double[size];
        Random rnd = new Random();
        double maxDecimalPlace = Math.pow(10, scale);
        for (int i = 0; i < randomNumArray.length; i++) {
                randomNumArray[i] = Math.round(rnd.nextDouble() * max * maxDecimalPlace) / maxDecimalPlace;
        }
        return randomNumArray;
    }

    public double roundAfterSum(double[] numbers) {
        double sumNumbers = 0.0;
        for (double randomNum: numbers) {
            sumNumbers += randomNum;
        }
        return Math.round(sumNumbers);
    }

    public double sumAfterRound(double[] numbers) {
        double sumNumbers = 0.0;
        for (double randomNum: numbers) {
            sumNumbers += Math.round(randomNum);
        }
        return sumNumbers;
    }

    public double difference(int size, double max, int scale) {
        double[] temp = randomNumbers(size, max, scale);
        return Math.abs(roundAfterSum(temp) - sumAfterRound(temp));
    }

    public static void main(String[] args) {
        RoundingAnomaly rounding = new RoundingAnomaly();
        double diffSum = 0.0;
        for (int i = 0; i < 100; i++) {
            diffSum += rounding.difference(1000, 1000000,5);
        }
        System.out.println(diffSum / 100.0);
    }

}
