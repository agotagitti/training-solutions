package week02d5;

import java.util.Arrays;
import java.util.List;

public class Languages {

    public static void main(String[] args) {

        List<String> test = Arrays.asList("Java", "Python", "JavaScript");

        //5 karakternél hosszabbat kiírni

        for (String x: test) {
            if (x.length() > 5) {
                System.out.println(x);
            }
        }
    }
}
