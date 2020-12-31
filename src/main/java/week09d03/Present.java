package week09d03;

public enum Present {

    TOY(14),
    ELECTRONIC(199),
    HOUSEKEEPING(199),
    DECORATION(199);

    private int maxGiftableAge;

    Present(int maxGiftableAge) {
        this.maxGiftableAge = maxGiftableAge;
    }

    public int getMaxGiftableAge() {
        return maxGiftableAge;
    }

}
