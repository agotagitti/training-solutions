package exceptionmulticatch.converter;

public class BinaryStringConverter {

    public boolean[] binaryStringToBooleanArray(String string) {
        if (string == null) {
            throw new NullPointerException("binaryString null");
        }
        String[] splitString = string.split("");
        boolean[] stringArray = new boolean[splitString.length];
        for (int i = 0; i < splitString.length; i++) {
            if (splitString[i].equals("1")) {
                stringArray[i] = true;
            } else if (splitString[i].equals("0")) {
                stringArray[i] = false;
            } else {
                throw new IllegalArgumentException("binaryString not valid");
            }
        }
        return stringArray;
    }

    public String booleanArrayToBinaryString(boolean[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Empty array");
        }
        StringBuilder sb = new StringBuilder();
        for (boolean actual: array) {
            if (actual) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
        return sb.toString();
    }


}

