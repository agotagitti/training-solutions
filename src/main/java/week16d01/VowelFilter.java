package week16d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class VowelFilter {

    private static final String CONSONANTS = "bcdfghjklmnpqrstvwxyz";

    public String filterVowels(BufferedReader reader) throws IOException {
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            for (char actual : line.toCharArray()) {
                if (isConsonant(actual)) {
                    result.append(actual);
                }
            }
            result.append("\n");
        }
        return result.toString();
    }

    public boolean isConsonant(char character) {
        return CONSONANTS.contains(Character.toString(character).toLowerCase());
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(VowelFilter.class.getResourceAsStream("/vowels.txt")))) {
            String result = new VowelFilter().filterVowels(reader);
            System.out.println(result);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }

    }

}
