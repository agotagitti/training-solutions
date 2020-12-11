package initalizer;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {

    public static final List<Rate> ACTUAL_RATES;
    public long balance;

    static {
        List<Rate> rateList = new ArrayList<>();
        rateList.add(new Rate(Currency.HUF, 1.0));
        rateList.add(new Rate(Currency.EUR, 308.23));
        rateList.add(new Rate(Currency.SFR, 289.24));
        rateList.add(new Rate(Currency.GBP, 362.23));
        rateList.add(new Rate(Currency.USD, 289.77));
        ACTUAL_RATES = rateList;
    }

    public CreditCard(long balance, Currency currency, List<Rate> rates) {
        this.balance = (long) (balance * getRate(currency, rates).getConversionFactor());

    }

    public CreditCard(long balance, Currency currency) {
        this.balance = (long) (balance * getRate(currency).getConversionFactor());

    }

    private Rate getRate(Currency currency) {
        return getRate(currency, ACTUAL_RATES);
    }

    private Rate getRate(Currency currency, List<Rate> rates) {
        for (Rate actual: rates) {
            if (actual.getCurrency() == currency) {
                return actual;
            }
        }
        throw new IllegalArgumentException("Cannot find currency");
    }


    public CreditCard(long balance) {
        this.balance = balance;
    }

    public boolean payment(long amount, Currency currency) {
        long newBalance = (long) (balance - amount * getRate(currency).getConversionFactor());
        if (newBalance >= 0) {
            this.balance = newBalance;
            return true;
        }
        return false;
    }

    public boolean payment(long amount) {
        return payment(amount, Currency.HUF);
    }

    public long getBalance() {
        return balance;
    }
}
