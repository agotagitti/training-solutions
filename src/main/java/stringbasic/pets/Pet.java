package stringbasic.pets;

import java.time.LocalDate;

public class Pet {

    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String registrationNumber;

    public Pet(String name, LocalDate dateOfBirth, Gender gender, String registrationNumber) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        if (registrationNumber.length() != 6) {
            throw new IllegalArgumentException("Invalid registration number " + registrationNumber);
        }
        try {
            Integer.parseInt(registrationNumber);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException("Invalid registration number " + registrationNumber);
        }
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
