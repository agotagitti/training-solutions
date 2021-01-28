package iofilestest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> bookList = new ArrayList<>();

    public void add(Book... books) {
        for(Book actual: books) {
            if (!bookList.contains(actual)) {
                bookList.add(actual);
            }
        }
    }

    public void saveBooks(Path path) {
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
             for (Book actual: bookList) {
                 bw.write(actual.getAuthor() + ";" + actual.getTitle() + "\n");
             }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file", e);
        }
    }

    public void loadBooks(Path path) {
        List<Book> loadedBooks = new ArrayList<>();
        try(BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] bookData = line.split(";");
                loadedBooks.add(new Book(bookData[0], bookData[1]));
            }
            resetBookList();
            for (Book actual: loadedBooks) {
                add(actual);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    private void resetBookList() {
        bookList = new ArrayList<>();
    }

    public List<Book> getBookList() {
        return new ArrayList<>(bookList);
    }
}
