package week04;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
       System.out.println(main.getIndexesOfChar("abcdefa", 'a'));

    }

    public List<Integer> getIndexesOfChar(String str, char c) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < str.length(); i++) {
           if(str.charAt(i) == c) {
               result.add(i);
           }
        }
        return result;
    }
}