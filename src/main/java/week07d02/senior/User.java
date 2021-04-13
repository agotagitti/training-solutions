package week07d02.senior;

public interface User {

    String getUserName();

    String getFirstName();

    String getLastName();

    default String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    static User of() {
        return new User() {
            @Override
            public String getUserName() {
                return null;
            }

            @Override
            public String getFirstName() {
                return null;
            }

            @Override
            public String getLastName() {
                return null;
            }
        };
    }
}
