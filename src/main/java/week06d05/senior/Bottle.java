package week06d05.senior;

public class Bottle {

    private BottleType type;
    private int filledUntil;

    public Bottle(BottleType type, int filledUntil) {
        this.type = type;
        if (filledUntil > type.getMaximumAmount()) {
            throw new IllegalArgumentException("Amount cannot go over maximum capacity");
        }
        this.filledUntil = filledUntil;
    }

    public BottleType getType() {
        return type;
    }

    public int getFilledUntil() {
        return filledUntil;
    }

    public static Bottle of(BottleType bottleType) {
        return new Bottle(bottleType, 0);
    }

    public void fill(int fillAmount) {
        if (type.getMaximumAmount() > filledUntil) {
            if (type.getMaximumAmount() - filledUntil < fillAmount) {
                throw new IllegalArgumentException("Too much liquid");
            } else {
                filledUntil += fillAmount;
            }
        } else if (type.getMaximumAmount() == filledUntil) {
            throw new IllegalArgumentException("Bottle already full");
        }
    }

}
