package inheritancemethods.bankaccount;

public class CreditAccount extends DebitAccount{

    private long overdraftLimit;

    public CreditAccount(String accountNumber, long balance, long overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean transaction(long amount) {
        long fullCost = costOfTransaction(amount) + amount;
        if (fullCost > getBalance() + overdraftLimit) {
            return false;
        }
        if (fullCost <= getBalance()) {
            super.transaction(amount);
        } else {
            overdraftLimit -= fullCost - getBalance();
            balanceToZero();
        }
        return true;
    }

    public long getOverdraftLimit() {
        return overdraftLimit;
    }
}
