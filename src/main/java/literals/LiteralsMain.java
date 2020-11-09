package literals;

public class LiteralsMain {

    public static void main(String[] args) {
        String number = "1" + "2";
        System.out.println(1 + "" + 2);
        String number2 = String.valueOf(1);
        String number3 = Integer.toString(3);
        System.out.println(number2);
        System.out.println(number3);

        double quotient = 3 / 4;
        System.out.println(quotient); // 0.0
//        double quotient2 = 3 / 4.0;
//        System.out.println(quotient2); // 0.75
        double quotient3 = 3d / 4;
        System.out.println(quotient3); // 0.75

        long big = 3_244_444_444L;

//        String s = árvíztűrőtükörfúrógép;
//        System.out.println(s);

        String word = "title".toUpperCase();
        System.out.println(word);

        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(-2));



    }

}
