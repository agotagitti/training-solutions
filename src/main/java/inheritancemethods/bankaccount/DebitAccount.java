package inheritancemethods.bankaccount;

public class DebitAccount {

    private static final double COST = 3.0;
    private static final long MIN_COST = 200;
    private String accountNumber;
    private long balance;

    public DebitAccount(String accountNumber, long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public final long costOfTransaction(long amount) {
        double costByPercent = amount * COST / 100;
        long transactionCost = 0L;
        if (costByPercent < MIN_COST) {
            transactionCost = MIN_COST;
        } else {
            transactionCost = (long) costByPercent;
         }
        return transactionCost;
    }

    public boolean transaction(long amount) {
        if (balance < amount + costOfTransaction(amount)) {
            return false;
        } else {
            balance -= amount + costOfTransaction(amount);
            return true;
        }
    }

    public void balanceToZero() {
        balance = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }
}
