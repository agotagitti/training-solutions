package introexception.patient;

public class Patient {

    private String name;
    private String socialSecurityNumber;
    private int yearOfBirth;

    public Patient(String name, String ssn, int year) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Name cannot be empty!");
        }
        this.name = name;
        if (year < 1900) {
            throw new IllegalArgumentException("Invalid year of Birth" + year);
        }
        yearOfBirth = year;
        if (!new SsnValidator().isValidSsn(ssn)) {
            throw new IllegalArgumentException("Invalid Social Security Number " + ssn);
        }
        socialSecurityNumber = ssn;
    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
