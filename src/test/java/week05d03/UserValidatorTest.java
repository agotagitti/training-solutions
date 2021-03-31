package week05d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

    UserValidator userValidator = new UserValidator();


    @Test
    void validate() {
        List<User> usersBad1 = List.of(
                new User("Jane", 34),
                new User("John", 121));
        List<User> usersBad2 = List.of(
                new User("Jane", 34),
                new User(null, 21));
        List<User> usersGood = List.of(
                new User("Jane", 34),
                new User("John", 21));
        assertEquals("All user valid", userValidator.validate(usersGood));
        assertThrows(InvalidArgumentException.class, () -> {
            userValidator.validate(usersBad1);
        });
        assertThrows(InvalidArgumentException.class, () -> {
            userValidator.validate(usersBad2);
        });
    }
}