package collectionslist.collectionsarraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottery {

    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {
        //lotteryType = number of balls to draw
        if (lotteryType >= ballCount) {
            throw new IllegalArgumentException("Balls must be more then the winning numbers!");
        }
        return shuffle(numbersToDraw(ballCount)).subList(0, lotteryType);
    }

    private List<Integer> numbersToDraw (int ballCount) {
        List<Integer> possibleNumbers = new ArrayList<>();
        for (int i = 1; i <= ballCount; i++) {
            possibleNumbers.add(i);
        }
        return possibleNumbers;
    }

    private List<Integer> shuffle(List<Integer> balls) {
        Collections.shuffle(balls);
        return balls;
    }

}
