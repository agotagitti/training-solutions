package week06d03;

import java.util.Scanner;

public class WordEraser {

    public String eraseWord(String words, String word) {
        Scanner scanner = new Scanner(words);
        StringBuilder notErased = new StringBuilder();
        while (scanner.hasNext()) {
            String next = scanner.next();
            if (!next.equalsIgnoreCase(word)) {
                if (!notErased.isEmpty()) {
                    notErased.append(" ");
                }
                notErased.append(next);
            }
        }
        return notErased.toString();
    }

}
