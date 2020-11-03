package stringtype.registration;

import java.util.Scanner;

public class Registration {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username:");
        String username = scanner.nextLine();

        System.out.println("Password:");
        String password1 = scanner.nextLine();
        System.out.println("Password again");
        String password2 = scanner.nextLine();


        System.out.println("Email:");
        String email = scanner.nextLine();

        UserValidator userValidator = new UserValidator();

        System.out.println("Username is " + (userValidator.isValidUsername(username) ? "valid" : "invalid"));
        System.out.println("Password is " + (userValidator.isValidPassword(password1, password2) ? "valid" : "invalid"));
        System.out.println("Email is " + (userValidator.isValidEmail(email) ? "valid" : "invalid"));


    }

}
