package week13d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LongestName {

    public String getLongestName() {
        InputStreamReader inputStreamReader = new InputStreamReader(LongestName.class.getResourceAsStream("/iranyitoszamok-varosok-2021.csv"));
        String result = "";
        try (BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String line;
            bufferedReader.readLine();
            while((line = bufferedReader.readLine()) != null) {
                if (line.split(";")[1].length() > result.length()) {
                    result = line.split(";")[1];
                }
            }
        }
        catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LongestName().getLongestName());
    }

}
