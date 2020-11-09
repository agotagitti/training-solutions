package week02.project1;

import java.util.Scanner;

public class Controller {

    private Office office;

    public static void main(String[] args) {
        Controller controller = new Controller();

        controller.readOffice();
        for (int i = 0; i == 0; i = 0) {
            controller.printMenu();
            controller.runMenu();
        }
    }

        public void readOffice() {
            this.office = new Office();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Number of meeting rooms:");
            int numberOfMeetingRoom = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < numberOfMeetingRoom; i++) {
                System.out.println("Name of meeting room" + (i + 1) + ":");
                String nameOfMeetingRoom = scanner.nextLine();
                System.out.println("Length of meeting room" + (i + 1) + ":");
                int lengthOfMeetingRoom = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Width of meeting room" + (i + 1) + ":");
                int widthOfMeetingRoom = scanner.nextInt();
                scanner.nextLine();
                office.addMeetingRoom(new MeetingRoom(nameOfMeetingRoom, lengthOfMeetingRoom, widthOfMeetingRoom));
            }
        }

        public void printMenu() {
            System.out.println("1. Meeting rooms in order");
            System.out.println("2. Meeting room in reverse order");
            System.out.println("3. Every second meeting room");
            System.out.println("4. Areas of meeting rooms");
            System.out.println("5. Search using exact meeting room name");
            System.out.println("6. Search using part of meeting room name");
            System.out.println("7. Search by area of meeting rooms" + '\n');
        }

        public void runMenu() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Give me a number:");
            int menuNumber = scanner.nextInt();
            scanner.nextLine();
            if (menuNumber == 1) {
                office.printNames();
            }
            if (menuNumber == 2) {
                office.printNamesReverse();
            }
            if (menuNumber == 3) {
                office.printEvenNames();
            }
            if (menuNumber == 4) {
                office.printAreas();
            }
            if (menuNumber == 5) {
                System.out.println("Please give me the name of the meeting room:");
                office.printMeetingRoomsWithName(scanner.nextLine());
            }
            if (menuNumber == 6) {
                System.out.println("Please give me part of the name of a meeting room:");
                office.printMeetingRoomsContains(scanner.nextLine());
            }
            if (menuNumber == 7) {
                System.out.println("Please give me the size of the meeting room:");
                office.printAreasLargerThan(scanner.nextInt());
                scanner.nextLine();
            }
            if (menuNumber > 7) {
                System.out.println("Invalid menu");
            }
        }



}

