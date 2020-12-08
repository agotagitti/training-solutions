package staticattrmeth.bank;

import java.math.BigDecimal;

public class BankTransaction {

    private static final long MIN_VALUE = 1;
    private static final long MAX_VALUE = 10_000_000;
    private static long currentMinValue = MAX_VALUE;
    private static long currentMaxValue = MIN_VALUE;
    private static int counter = 0;
    private static BigDecimal sumOfTrxs = new BigDecimal(0);
    private long trxValue;


    public BankTransaction(long trxValue) {
        if (trxValue < MIN_VALUE || trxValue > MAX_VALUE) {
            throw new IllegalArgumentException("Invalid value");
        }
        counter++;
        sumOfTrxs = sumOfTrxs.add(new BigDecimal(trxValue));
        if (trxValue < currentMinValue) {
            currentMinValue = trxValue;
        }
        if (trxValue > currentMaxValue) {
            currentMaxValue = trxValue;
        }
        this.trxValue = trxValue;
    }

    public static void initTheDay() {
        currentMinValue = MAX_VALUE;
        currentMaxValue = MIN_VALUE;
        counter = 0;
        sumOfTrxs = new BigDecimal(0);
    }

    public static BigDecimal averageOfTransaction() {
        return counter == 0 ? new BigDecimal(0) : sumOfTrxs.divide(new BigDecimal(counter));
    }

    public static BigDecimal getSumOfTrxs() {
        return sumOfTrxs;
    }

    public static long getCurrentMinValue() {
        return counter == 0 ? 0 : currentMinValue;
    }

    public static long getCurrentMaxValue() {
        return counter == 0 ? 0 : currentMaxValue;
    }

    public long getTrxValue() {
        return trxValue;
    }
}