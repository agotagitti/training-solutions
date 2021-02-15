package week16d01;

public enum CanoeType {

    RED(1.0),
    GREEN(1.2),
    BLUE(1.5);

    private double bonus;

    CanoeType(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }
}
