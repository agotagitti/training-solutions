package algorithmsmax.sales;

import java.util.List;

public class SalesAmountMaxSelector {

    public Salesperson selectSalesPersonWithMaxSalesAmount(List<Salesperson> salespersons) {
        Salesperson winner = null;
        for (Salesperson actual: salespersons) {
            if (winner == null || (actual.getAmount() > winner.getAmount())) {
                winner = actual;
            }
        }
        return winner;
    }

}
