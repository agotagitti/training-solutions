package iofilestest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTest {

    @TempDir
    public Path tempFolder;

    private Library library = new Library();

    private Book book1 = new Book("A", "a");
    private Book book2 = new Book("B", "b");
    private Book book3 = new Book("C", "c");

    @Test
    void testAdd() throws IOException {
        library.add(book1, book2, book3);
        assertEquals(3, library.getBookList().size());
    }

    @Test
    void testSaveBooks() throws IOException {
        Path file = Files.createFile(tempFolder.resolve("test.txt"));
        library.add(book1, book2, book3);
        library.saveBooks(file);
        List<String> testList = Files.readAllLines(file);
        System.out.println(testList);
        assertEquals(3, testList.size());
        assertEquals("B;b", testList.get(1));
    }

    @Test
    void testLoadBooks() throws IOException {
        Path file = Files.createFile(tempFolder.resolve("test.txt"));
        library.add(book1, book2, book3);
        library.saveBooks(file);
        library.loadBooks(file);
        assertEquals(3, library.getBookList().size());
        assertEquals("C", library.getBookList().get(2).getAuthor());
        assertEquals("c", library.getBookList().get(2).getTitle());
    }
}
