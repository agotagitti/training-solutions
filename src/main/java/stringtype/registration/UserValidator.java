package stringtype.registration;

public class UserValidator {

    public boolean isValidUsername(String username) {
        boolean result = !(username.length() == 0);
        return  result;
    }

    public boolean isValidPassword(String password1, String password2) {
        boolean passwordCheck1 = password1.length() >= 8;
        boolean passwordCheck2 = password1.equals(password2);

        return passwordCheck1 && passwordCheck2;

        //boolean result = (password1.length() >= 8) && (password1.equals(password2));
        //return result;
    }

    public boolean isValidEmail(String email) {
        boolean emailCheck1 = email.indexOf("@") != -1;
        boolean emailCheck2 = email.indexOf(".") > email.indexOf("@");
        boolean emailCheck3 = email.indexOf(".") > (email.indexOf("@") + 1);
        boolean emailCheck4 = email.indexOf("@") > 0;
        boolean emailCheck5 = email.indexOf(".") < (email.length() - 1);

        return emailCheck1 && emailCheck2 && emailCheck3 && emailCheck4 && emailCheck5;
    }


}
