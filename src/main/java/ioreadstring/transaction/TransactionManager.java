package ioreadstring.transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

    private List<BankAccount> accountList = new ArrayList<>();


    public List<BankAccount> getAccountList() {
        return accountList;
    }

    public void uploadListFromFile(String fileName) {
        Path path = Path.of(fileName);
        try {
            List<String> accounts = Files.readAllLines(path);
            for (String actual: accounts) {
                String[] accElements = actual.split(";");
                BankAccount bankAccount = new BankAccount(accElements[0], accElements[1], Integer.parseInt(accElements[2]));
                accountList.add(bankAccount);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
        catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Invalid transaction amount", nfe);
        }
    }

    public void makeTransactions(String fileName) {
        Path path = Path.of(fileName);
        try {
            List<String> transactions = Files.readAllLines(path);
            for (String actual: transactions) {
                String[] transElements = actual.split(";");
                findBankAccount(transElements[0]).setBalance(Integer.parseInt(transElements[1]));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
        catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Invalid transaction amount", nfe);
        }
    }

    private BankAccount findBankAccount(String accountNumber) {
        for (BankAccount actual: accountList) {
            if (accountNumber.equals(actual.getAccountNumber())) {
                return  actual;
            }
        }
        throw new IllegalArgumentException("Cannot find bank account: " + accountNumber);
    }

}
