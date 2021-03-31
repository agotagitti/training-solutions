package week06d01.senior;

public class SeparatedSum {

    public String sum(String s) {
        isStringValid(s);
        String sWithDot = s.replace(",", ".");
        double negative = 0.0;
        double positive = 0.0;
        String result = "String value is ";
        try {
            if (!sWithDot.contains(";")) {
                Double.parseDouble(sWithDot);
                return result + sWithDot;
            } else {
                String[] stringData = sWithDot.split(";");
                for(String actual : stringData) {
                    if (Double.parseDouble(actual) < 0.0) {
                        negative += Double.parseDouble(actual);
                    } else {
                        positive += Double.parseDouble(actual);
                    }
                }
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid value in String");
        }
        return result + negative + " + " + positive;
    }

    private void isStringValid(String s) {
        if (s == null || s.isBlank() || !s.contains(",")) {
            throw new IllegalArgumentException("Invalid String");
        }
    }
}
