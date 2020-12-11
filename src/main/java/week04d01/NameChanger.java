package week04d01;

public class NameChanger {

    private String fullName;

    public NameChanger(String fullname) {
        if (fullname == null || fullname.equals("")) {
            throw new IllegalArgumentException("Invalid Name: " + fullname);
        }
        this.fullName = fullname;
    }

    public void changeFirstName(String firstName) {
        fullName = firstName + fullName.substring(fullName.indexOf(" "));
    }

    public String getFullname() {
        return fullName;
    }
}
