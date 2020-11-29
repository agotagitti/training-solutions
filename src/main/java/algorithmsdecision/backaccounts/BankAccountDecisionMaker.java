package algorithmsdecision.backaccounts;

import java.util.List;

public class BankAccountDecisionMaker {

    public boolean containsBalanceGreaterThan(List<BankAccount> accounts, int amount) {
        boolean enoughMoney = false;
        for (BankAccount actual: accounts) {
            if (actual.getBalance() > amount) {
                enoughMoney = true;
            }
        }
        return enoughMoney;
    }

}
