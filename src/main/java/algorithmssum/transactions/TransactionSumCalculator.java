package algorithmssum.transactions;

import java.util.List;

public class TransactionSumCalculator {

    public int sumAmountOfCreditEntries(List<Transaction> transactions) {
        int sum = 0;
        for (Transaction actual: transactions) {
            if (actual.isCredit()) {
                sum += actual.getAmount();
            }
        }
        return sum;
    }

}
