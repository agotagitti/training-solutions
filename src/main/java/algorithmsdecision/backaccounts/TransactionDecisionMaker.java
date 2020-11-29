package algorithmsdecision.backaccounts;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionDecisionMaker {

    public boolean containsCreditEntryGreaterThan(List<Transaction> transactions, LocalDateTime startTime, LocalDateTime endTime, int amount) {
        boolean result = false;
        for (Transaction actual: transactions) {
            if(actual.isDebit() && actual.getDateOfTransaction().isAfter(startTime) && actual.getDateOfTransaction().isBefore(endTime) && actual.getAmount() > amount) {
                result = true;
                break;
            }
        }
        return result;
    }

}
