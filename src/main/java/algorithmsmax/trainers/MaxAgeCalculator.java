package algorithmsmax.trainers;

import java.util.List;

public class MaxAgeCalculator {

    public Trainer trainerWithMaxAge(List<Trainer> trainers) {
        Trainer oldest = null;
        for (Trainer actual: trainers) {
            if (oldest == null || (actual.getAge() > oldest.getAge())) {
                oldest = actual;
            }
        }
        return oldest;
    }

}
