package week10d02;

import java.util.List;

public class MaxTravel {

    public int getMaxIndex(List<Integer> numbers) {
        int[] maxNoPerStop = new int[30];
        int max = 0;
        for (int actual: numbers) {
            maxNoPerStop[actual]++;
        }
        for(int i = 1; i < maxNoPerStop.length; i++) {
            if (maxNoPerStop[i] > maxNoPerStop[max]) {
                max = i;
            }
        }
        return max;
    }

}
