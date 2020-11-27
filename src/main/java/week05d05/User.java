package week05d05;

public class User {

    private String firstName;
    private String lastName;
    private String email;

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (!((email.indexOf("@") > 0) && (email.indexOf("@") < email.indexOf(".", email.indexOf("@"))))) {
            throw new IllegalArgumentException("Email is not valid!");
        }
        this.email = email;

    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
