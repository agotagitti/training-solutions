package week05d03;

import java.util.List;

public class UserValidator {

    public String validate(List<User> users) {
        for (User actualUser : users) {
            if (actualUser.getName() == null || actualUser.getName().isBlank()) {
                throw new InvalidArgumentException("Invalid user name");
            } else if (actualUser.getAge() < 1 || actualUser.getAge() > 120) {
                throw new InvalidArgumentException("Invalid user age");
            }
        }
        return "All user valid";
    }

}
