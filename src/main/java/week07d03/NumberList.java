package week07d03;


import java.util.List;

public class NumberList {

    public boolean isIncreasing(List<Integer> integerList) {
        int numberToCompare = 0;
        boolean increasing = true;
        for (Integer actual: integerList) {
            if (actual < numberToCompare) {
                increasing = false;
                break;
            }
            numberToCompare = actual;
        }
        return increasing;
    }

}
