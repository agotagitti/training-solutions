package stringbasic.stringbasic;

public class StringCreator {

    public String createStringForHeap() {
        return new String("abc");
    }

    public String createStringForPool() {
        return "abc";
    }
}
