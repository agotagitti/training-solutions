package week06d01;

import java.util.ArrayList;
import java.util.List;

public class ListSelector {

    public String evenOrOdd (List<String> text) {
        String even = "";
        if (text == null) {
            throw new IllegalArgumentException("List cannot be empty!");
        }
        for (int i = 0; i < text.size(); i += 2) {
            if (i == 0) {
                even += text.get(i);
            } else {
                even += ", " + text.get(i);
            }
        }
        if (!even.equals("")) {
            return "[" + even + "]";
        } else {
            return even;
        }
    }

}
