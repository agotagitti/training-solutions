package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestAboveTargetSelector {

    public Salesperson selectSalesPersonWithFurthestAboveTarget(List<Salesperson> salespersons) {
        Salesperson winner = null;
        for (Salesperson actual: salespersons) {
            if (winner  == null || (actual.getDifferenceFromTarget() > winner.getDifferenceFromTarget())) {
                winner = actual;
            }
        }
        return winner;
    }

}
