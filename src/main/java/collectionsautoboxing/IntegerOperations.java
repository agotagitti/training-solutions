package collectionsautoboxing;

import java.util.ArrayList;
import java.util.List;

public class IntegerOperations {

    public List<Integer> createList(int... numbers) {
        List<Integer> integerList = new ArrayList<>();
        for (int actual: numbers) {
            integerList.add(actual);
        }
        return  integerList;
    }

    public int sumIntegerList(List<Integer> integerList) {
        int count = 0;
        for (Integer actual: integerList) {
            count += actual;
        }
        return count;
    }

    public int sumIntegerObjects(Integer... integers) {
        int count = 0;
        for (Integer actual: integers) {
            count += actual;
        }
        return count;
    }

}
