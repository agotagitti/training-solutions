package algorithmsdecision.backaccounts;

import java.util.List;

public class TransactionExecutor {

    public void executeTransactions(List<Transaction> transactions, List<BankAccount> accounts) {
        for (Transaction actualTransaction: transactions) {
            boolean isSucceeded = false;
            for (BankAccount actualBankAccount: accounts) {
                if (actualBankAccount.getAccountNumber().equals(actualTransaction.getAccountNumber())) {
                    if (actualTransaction.isCredit()) {
                        isSucceeded = actualBankAccount.deposit(actualTransaction.getAmount());
                    } else {
                        isSucceeded = actualBankAccount.withdraw(actualTransaction.getAmount());
                    }
                    break;
                }
            }
            if (isSucceeded) {
                actualTransaction.setStatus(TransactionStatus.SUCCEEDED);
            } else {
                actualTransaction.setStatus(TransactionStatus.PENDING);
            }
        }
    }
}
