package localvariables;

public class LocalVariablesMain {

    public static void main(String[] args) {
        boolean b;

        //System.out.println("b: " + b); //nincs még érték adva

        b = false;

        System.out.println("b: " + b);

        int a = 2;

        int i = 3, j = 4;

        //System.out.println("k: " + k); //nincs még definiálva

        int k = i;

        System.out.println("k: " + k);

        String s = "Hello World!";

        String t = s;

        {
            int x = 0;

            System.out.println("a: " + a);
        }

        //System.out.println("x: " + x); //a másik blokk lokális változóját használná

    }
}
