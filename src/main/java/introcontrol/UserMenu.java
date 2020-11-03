package introcontrol;

import java.util.Scanner;

public class UserMenu {

    public static void main(String[] args) {
        System.out.println("1. Felhasználók listázása");
        System.out.println("2. Felhasználó felvétele");
        System.out.println("Többi: Kilépés");

        System.out.println("Válassz menüt!");
        Scanner scanner = new Scanner(System.in);
        int menuNumber = scanner.nextInt();

        if (menuNumber == 1) {
            System.out.println("Felhasználók listázása");
        }
        if (menuNumber == 2) {
            System.out.println("Felhasználó felvétele");
        }

    }
}
