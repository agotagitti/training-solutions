package collectionslist.collectionslinkedlist;

import java.util.*;

public class Draw {


    public Set<Integer> drawNumbers(int drawCount, int maxNumber) {
        if (drawCount >= maxNumber) {
            throw new IllegalArgumentException("drawCount must be less then 8!");
        }
        Queue<Integer> queue = new LinkedList<>(shuffle(numbersToDraw(maxNumber)));
        Set<Integer> winnerNumbers = new TreeSet<>();
        for (int i = 0; i < 5; i++) {
            winnerNumbers.add(queue.poll());
        }
        return winnerNumbers;
    }

    private List<Integer> numbersToDraw (int maxNumber) {
        List<Integer> possibleNumbers = new LinkedList<>();
        for (int i = 1; i <= maxNumber; i++) {
            possibleNumbers.add(i);
        }
        return possibleNumbers;
    }

    private List<Integer> shuffle(List<Integer> balls) {
        Collections.shuffle(balls);
        return balls;
    }

}
