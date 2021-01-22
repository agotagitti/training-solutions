package exceptionclass.bank;

import java.util.List;

public class Bank {

    private List<Account> accounts;

    public Bank(List<Account> accounts) {
        if (accounts == null) {
            throw new IllegalArgumentException("Invalid argument");
        }
        this.accounts = accounts;
    }

    public void payment(String accountNumber, double amount) {
        if (amount < 0) {
            throw new InvalidBankOperationException("Invalid amount", ErrorCode.INVALID_AMOUNT);
        }
        findAccount(accountNumber).subtract(amount);
    }

    public void deposit(String accountNumber, double amount) {
        if (amount < 0) {
            throw new InvalidBankOperationException("Invalid amount", ErrorCode.INVALID_AMOUNT);
        }
        findAccount(accountNumber).deposit(amount);
    }

    private Account findAccount(String accountNumber) {
        for (Account actual: accounts) {
            if (accountNumber.equals(actual.getAccountNumber())) {
                return actual;
            }
        }
        throw new InvalidBankOperationException("Unknown account", ErrorCode.INVALID_ACCOUNTNUMBER);
    }

}
