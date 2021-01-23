package ioreadstring.transaction;

public class BankAccount {

    private final String name;
    private final String accountNumber;
    private int balance;

    public BankAccount(String name, String accountNumber, int balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setBalance(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }
}
