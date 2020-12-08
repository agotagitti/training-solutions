package methodoverloading.pub;

import java.util.ArrayList;
import java.util.List;

public class ListOfGoodPubs {

    private List<Pub> goodPubs = new ArrayList<>();

    public ListOfGoodPubs(List<Pub> goodPubs) {
        if (goodPubs == null || goodPubs.isEmpty()) {
            throw new IllegalArgumentException("Pub list is empty!");
        }
        this.goodPubs = goodPubs;
    }

    public Pub findTheBest() {
        Pub best = null;
        for (Pub actual: goodPubs) {
            if (best == null || actual.getOpenFrom().isEarlier(best.getOpenFrom())) {
                best = actual;
            }
        }
        return best;
    }

}
