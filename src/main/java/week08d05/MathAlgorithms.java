package week08d05;

import java.util.ArrayList;
import java.util.List;

public class MathAlgorithms {

    public int greatestCommonDivider(int x, int y) {
        List<Integer> xList = numberList(x);
        List<Integer> yList = numberList(y);
        for (int i = xList.size() - 1; i >= 0; i--) {
            if (yList.contains(xList.get(i))) {
                return xList.get(i);
            }
        }
        return 1;
    }

    private List<Integer> numberList(int number) {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 1; i <= number/2; i++) {
            if (number % i == 0) {
                numberList.add(i);
            }
        }
        numberList.add(number);
        return numberList;
    }

}
