package finalmodifier;

import java.util.Arrays;
import java.util.List;

public class Week {

    final static List<String> DAYSOFWEEK = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");

    public static void main(String[] args) {

        DAYSOFWEEK.set(1,"Wednesday");

        System.out.println(DAYSOFWEEK.get(1));

        //DAYSOFWEEK = Arrays.asList("x", "y");

    }

}
