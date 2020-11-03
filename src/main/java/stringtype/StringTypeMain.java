package stringtype;

public class StringTypeMain {

    public static void main(String[] args) {

        String prefix = "Hello ";
        String name = "John Doe";
        String message = prefix + name;
        System.out.println(message);

        message += 444;
        System.out.println(message);

        boolean b = message.equals("Hello John Doe");
        boolean c = message.equals("Hello John Doe444");

        String x = "";
        String y = "";
        String xy = x + y;
        System.out.println("xy text is: " + xy);
        System.out.println("xy length is: " + xy.length());

        String abcde = "abcde";
        System.out.println(abcde.length());
        System.out.println(abcde.charAt(0) + ", " + abcde.charAt(2));
        System.out.println(abcde.substring(0, 3));

    }

}
