package introcontrol;

import java.util.Scanner;

public class BoatRental {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me the number of your party");
        int partyNumber = scanner.nextInt();
        int remainingPlaces = 10;

        if (partyNumber >= 5) {
            System.out.println("Boat nr 5 is taken");
            remainingPlaces -= 5;
            partyNumber -= 5;
        }

        if (partyNumber >= 3) {
            System.out.println("Boat nr 3 is taken");
            remainingPlaces -= 3;
            partyNumber -= 3;
        }

        if (partyNumber > 0) {
            System.out.println("Boat nr 2 is taken");
            remainingPlaces -= 2;
            partyNumber -= 2;
        }

        if (remainingPlaces < 0) {
            remainingPlaces = 0;
        }

        if (partyNumber < 0) {
            partyNumber = 0;
        }

        System.out.println("Remaining places: " + remainingPlaces);
        System.out.println("Waiting: " + partyNumber);
    }
}
