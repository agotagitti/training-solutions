package algorithmscount.bankaccounts;

import java.util.List;

public class BankAccountConditionCounter {

    public int countWithBalanceGreaterThan(List<BankAccount> bankaccounts, int balanceMin) {
        int counter = 0;
        for (BankAccount actual: bankaccounts) {
            if (actual.getBalance() > balanceMin) {
                counter++;
            }
        }
        return counter;
    }

}
