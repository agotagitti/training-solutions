package statements;

public class Investment {

    private double cost = 0.3;
    private int fund;
    private int interestRate;
    private boolean active = true;

    public Investment(int fund, int interestRate) {
        this.fund = fund;
        this.interestRate = interestRate;

    }

    public int getFund() {
        return fund;
    }

    public double getYield(int days) {
        return ((getFund() * (interestRate / 100.0)) / 365) * days;

    }

    public double close(int days) {
        double total = (getFund() + getYield(days)) - ((getFund() + getYield(days)) * (cost/100.0));
        double payedAmount = active ? total : 0;
        active = false;
        return payedAmount;
    }
}
