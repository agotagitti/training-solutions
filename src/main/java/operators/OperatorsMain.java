package operators;

public class OperatorsMain {

    public static void main(String[] args) {

        Operators operators = new Operators();
        System.out.println(operators.isEven(1));
        System.out.println(operators.isEven(2));

        System.out.println(Integer.toBinaryString(-16));
        System.out.println(Integer.toBinaryString(-16 >> 1));
        System.out.println(Integer.toBinaryString(-16 >>> 1));
        System.out.println(Integer.toBinaryString(-16 << 1));

        System.out.println(Integer.toBinaryString(13));
        System.out.println(Integer.toBinaryString(13 >> 1));
        System.out.println(Integer.toBinaryString(13 >>> 1));
        System.out.println(Integer.toBinaryString(13 << 1));

        System.out.println(operators.multiplyByPowerOfTwo(5, 3));

        int i = -1;
        String s = Integer.toBinaryString(i);
        System.out.println(s);
        int j = Long.valueOf(s, 2).intValue();
        System.out.println(j);

        System.out.println(0332);
        System.out.println(0333);
        System.out.println(0334);
        //octal

        int x = 5;
        int y = 2;
        int z = x++ + (x - 4) * y - 2;
        System.out.println(x + " " + z);
        //x++

    }
}
