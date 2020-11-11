package typeconversion.whichtype;

public class WhichTypeMain {

    public static void main(String[] args) {

        WhichType whichType = new WhichType();

        System.out.println(whichType.whichType("9223372036854775"));
        System.out.println(whichType.whichType("32768"));
        System.out.println(whichType.whichType("-129"));
        System.out.println(whichType.whichType("127"));

    }
}
