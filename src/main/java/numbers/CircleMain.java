package numbers;

import java.util.Scanner;

public class CircleMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Circle 1 diameter:");
        int diam1 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Circle 2 diameter:");
        int diam2 = scanner.nextInt();
        scanner.nextLine();

        Circle circle1 = new Circle(diam1);
        Circle circle2 = new Circle(diam2);

        System.out.println("Circle1 perimeter:" + circle1.perimeter());
        System.out.println("Circle1 area:" + circle1.area());
        System.out.println("Circle2 perimeter:" + circle2.perimeter());
        System.out.println("Circle1 area:" + circle2.area());

    }
}
