package week02;

import java.util.Scanner;

public class InputNames {

    public static void main(String[] args) {
        String[] names = new String [5];
        for (int i = 0; i < names.length; i++) {
            System.out.println("Give me a name");
            Scanner scanner = new Scanner(System.in);
            names[i] = scanner.nextLine();
        }

        for (int j = 0; j < names.length; j++) {
            System.out.println(j+1 + ". elem: " + names[j]);
        }
    }

}
