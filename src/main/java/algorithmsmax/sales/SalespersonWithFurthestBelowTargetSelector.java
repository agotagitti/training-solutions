package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestBelowTargetSelector {

    public Salesperson selectSalesPersonWithFurthestBelowTarget(List<Salesperson> salespersons) {
        Salesperson winner = null;
        for (Salesperson actual: salespersons) {
            if (winner  == null || (actual.getDifferenceFromTarget() < winner.getDifferenceFromTarget())) {
                winner = actual;
            }
        }
        return winner;
    }

}
