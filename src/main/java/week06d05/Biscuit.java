package week06d05;

public class Biscuit {

    private BiscuitType type;
    private int gramAmount;

    public Biscuit(BiscuitType type, int gramAmount) {
        this.type = type;
        this.gramAmount = gramAmount;
    }

    public static Biscuit of(BiscuitType type, int gramAmount) {
        return new Biscuit(type, gramAmount);
    }

    public BiscuitType getType() {
        return type;
    }

    public int getGramAmount() {
        return gramAmount;
    }

    @Override
    public String toString() {
        return "Biscuit: " + type +
                ", " + gramAmount +
                " grams";
    }

}
