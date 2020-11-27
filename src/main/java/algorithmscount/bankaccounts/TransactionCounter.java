package algorithmscount.bankaccounts;

import java.util.List;

public class TransactionCounter {

    public int countEntryLessThan(List<Transaction> transactions, int amountMin) {
        int counter = 0;
        for (Transaction actual: transactions) {
            if (actual.getAmount() < amountMin) {
                counter++;
            }
        }
        return counter++;
    }

}
