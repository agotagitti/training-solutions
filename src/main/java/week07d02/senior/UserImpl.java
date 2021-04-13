package week07d02.senior;

public class UserImpl implements User {

    private String userName;
    private String firstName;
    private String lastName;

    public UserImpl(String userName, String firstName, String lastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

}
