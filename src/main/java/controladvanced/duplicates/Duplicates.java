package controladvanced.duplicates;

import java.util.ArrayList;
import java.util.List;

public class Duplicates {

    public List<Integer> find(List<Integer> integerList) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < integerList.size(); i++) {
            //if (!resultList.contains(integerList.get(i))) {
                for (int j = i + 1; j < integerList.size(); j++) {
                    if (integerList.get(i).equals(integerList.get(j))) {
                        resultList.add(integerList.get(i));
                        break;
                    }
                }
            //}
        }
        return resultList;
    }
}
