package ioconvert.shopping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListManager {

    public void saveShoppingList(OutputStream outputStream, List<String> shoppingList) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
            for (String actual: shoppingList) {
                writer.write(actual + '\n');
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file", e);
        }
    }

    public List<String> loadShoppingList(InputStream inputStream) {
        List<String> shoppingList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                shoppingList.add(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
        return shoppingList;
    }
}
