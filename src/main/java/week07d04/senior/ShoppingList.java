package week07d04.senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShoppingList {

    public long calculateSum(String path) {
        long sumPrice = 0L;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(ShoppingList.class.getResourceAsStream(path)))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineData = line.split(";");
                sumPrice += Long.parseLong(lineData[1]) * Long.parseLong(lineData[2]);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
        return sumPrice;
    }

    public static void main(String[] args) {
        ShoppingList shoppingList = new ShoppingList();
        System.out.println(shoppingList.calculateSum("/shoppinglist.txt"));
    }

}
