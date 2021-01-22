package exceptionclass.bank;

public class Account {

    private String accountNumber;
    private double balance;
    private double maxSubtract;

    public Account(String accountNumber, double balance) {
        if (accountNumber == null) {
            throw new IllegalArgumentException("Invalid account number");
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.maxSubtract = 100000.0;
    }

    public double subtract(double amount) {
        if (amount < 0.0) {
            throw new InvalidBankOperationException("Invalid amount", ErrorCode.INVALID_AMOUNT);
        }
        if (amount > balance) {
            throw new InvalidBankOperationException("Invalid amount", ErrorCode.LOW_BALANCE);
        }
        return balance -= amount;
    }

    public double deposit(double amount) {
        if (amount < 0) {
            throw new InvalidBankOperationException("Invalid amount", ErrorCode.INVALID_AMOUNT);
        }
        return balance += amount;
    }

    public void setMaxSubtract(double maxSubtract) {
        if (maxSubtract < 0) {
            throw new InvalidBankOperationException("Invalid amount", ErrorCode.INVALID_AMOUNT);
        }

        this.maxSubtract = maxSubtract;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getMaxSubtract() {
        return maxSubtract;
    }
}