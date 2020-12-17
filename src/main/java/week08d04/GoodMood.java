package week08d04;

public class GoodMood implements CanMark {

    @Override
    public int giveMark() {
        return 5;
    }

    public int giveBadMark() {
        return 4;
    }

}
