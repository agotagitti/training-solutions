package debug.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberStatistics {

    public List<Integer> numbers = new ArrayList<>();

    public NumberStatistics(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static void main(String[] args) {
        NumberStatistics stat = new NumberStatistics(Arrays.asList(4, 8, -1, -2, 4, 5, 3));

        System.out.println((new NumberStatistics(Arrays.asList(4, 8, -1, -2, 4, 5, 3)).sumPositives()));
        System.out.println((new NumberStatistics(Arrays.asList(4, 8, -1, -2, 4, 5, 3)).minDifferenceBetweenNeighbours()));
        System.out.println(new NumberStatistics(Arrays.asList(-3, -4)).sumPositives());
        System.out.println(new NumberStatistics(Arrays.asList(1)).minDifferenceBetweenNeighbours());

    }

    //másolt kód innentől
    public int sumPositives() {
        int sum = 0;
        for(int n: numbers) {
            if(n > 0) {
                sum += n;
            }
        }
        return sum;
    }

    public int minDifferenceBetweenNeighbours() {
        int minDifference = numbers.get(0) - numbers.get(1) >= 0 ? numbers.get(0) - numbers.get(1) : numbers.get(1) - numbers.get(0);
        for (int i = 1; i < numbers.size() - 1; i++) {
            int actDifference = numbers.get(i) - numbers.get(i+1) >= 0 ? numbers.get(i) - numbers.get(i+1) : numbers.get(i+1) - numbers.get(i);
            if (actDifference < minDifference) {
                minDifference = actDifference;
            }
        }
        return minDifference;

    }
}
