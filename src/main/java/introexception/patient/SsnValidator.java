package introexception.patient;

public class SsnValidator {

    public boolean isValidSsn(String ssn) {
        boolean isValid = false;
        int evenPosSum = 0;
        int oddPosSum = 0;
        if (ssn.length() == 9) {
            try {
                for (int i = 0; i < ssn.length() -1; i += 2) {
                    oddPosSum += Integer.parseInt(Character.toString(ssn.charAt(i)));
                }
                for (int i = 1; i < ssn.length(); i += 2) {
                    evenPosSum += Integer.parseInt(Character.toString(ssn.charAt(i)));
                }
                if ((oddPosSum * 3 + evenPosSum * 7) % 10 == Integer.parseInt(Character.toString(ssn.charAt(ssn.length() - 1)))) {
                    isValid = true;
                }
            } catch (NumberFormatException error) {
                isValid = false;
            }
        }
        return isValid;
    }
}
