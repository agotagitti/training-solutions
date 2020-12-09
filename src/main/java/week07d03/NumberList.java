package week07d03;


import java.util.List;

public class NumberList {

    public boolean isIncreasing(List<Integer> integerList) {
        if (integerList == null) {
            throw new IllegalArgumentException("List cannot be null");
        }
        int numberToCompare = 0;
        for (Integer actual: integerList) {
            if (actual < numberToCompare) {
                return false;
            }
            numberToCompare = actual;
        }
        return true;
    }

}
