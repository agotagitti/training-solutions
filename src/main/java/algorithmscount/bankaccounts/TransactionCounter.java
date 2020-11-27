package algorithmscount.bankaccounts;

import java.util.List;

public class TransactionCounter {

    public int countEntryLessThan(List<Transaction> transactions, int amountMax) {
        int counter = 0;
        for (Transaction actual: transactions) {
            if (actual.getAmount() < amountMax) {
                counter++;
            }
        }
        return counter++;
    }

}
