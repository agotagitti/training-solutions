package collectionslist.collectionslinkedlist;

import java.util.*;

public class Draw {


    public Set<Integer> drawNumbers(int drawCount, int maxNumber) {
        if (drawCount >= maxNumber) {
            throw new IllegalArgumentException("drawCount must be less then 8!");
        }
        Queue<Integer> queue = shuffle(numbersToDraw(maxNumber));
        Set<Integer> winnerNumbers = new TreeSet<>();
        for (int i = 0; i < 5; i++) {
            winnerNumbers.add(queue.poll());
        }
        return winnerNumbers;
    }

    private LinkedList<Integer> numbersToDraw (int maxNumber) {
        LinkedList<Integer> possibleNumbers = new LinkedList<>();
        for (int i = 1; i <= maxNumber; i++) {
            possibleNumbers.add(i);
        }
        return possibleNumbers;
    }

    private LinkedList<Integer> shuffle(LinkedList<Integer> balls) {
        Collections.shuffle(balls);
        return balls;
    }

}
