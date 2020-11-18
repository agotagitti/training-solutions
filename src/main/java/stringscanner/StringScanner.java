package stringscanner;

import java.util.Scanner;

public class StringScanner {

    public int readAndSumValues(String intString, String delimiter) {
        if (isEmpty(intString)) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }
        Scanner scanner;
        if (isEmpty(delimiter)) {
            scanner = new Scanner(intString);
        } else {
            scanner = new Scanner(intString).useDelimiter(delimiter);
        }
        String next = "";
        int sum = 0;
        while (scanner.hasNext()) {
            next = scanner.next();
            try {
                int value = Integer.parseInt(next);
                sum += value;
            } catch (NumberFormatException nfe) {
                throw new IllegalArgumentException("Incorrect parameter string!", nfe);
            }
        }
        return sum;
    }

    public int readAndSumValues(String intString) {
        return readAndSumValues(intString, " ");
    }

    public String filterLinesWithWordOccurrences(String text, String word) {
        if (isEmpty(text) || word == null || word.equals("")) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }
        Scanner scanner = new Scanner(text);
        String result = "";
        while(scanner.hasNextLine()) {
            String actual = scanner.nextLine();
            if (actual.contains(word)) {
                if (!result.equals("")) {
                    result += "\n";
                }
                result += actual;
            }
        }
        return result;
    }

    private boolean isEmpty(String str) {
        boolean isEmpty = false;
        if (str != null) {
            if(str.trim().equals("")) {
                isEmpty = true;
            }
        } else {
            isEmpty = true;
        }
        return isEmpty;
    }

}
