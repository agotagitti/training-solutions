package week08d02;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lottery {

    public List<Integer> getNumbers() {
        List<Integer> rndList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            rndList.add(rndNumber(rndList));
        }
        Collections.sort(rndList);
        return rndList;
    }

    private Integer rndNumber(List<Integer> listOfNumbers) {
        Random random = new Random();
        while (true) {
            Integer result = random.nextInt(90) + 1;
            if(!listOfNumbers.contains(result)) {
                return result;
            }
        }
    }

    public static void main(String[] args) {
        Lottery lottery = new Lottery();
        System.out.println(lottery.getNumbers());
    }

}
