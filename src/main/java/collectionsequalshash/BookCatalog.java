package collectionsequalshash;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookCatalog {

    public Book findBookByTitleAuthor(
            List<Book> books, String title, String author) {
        for (Book actual: books) {
            if (actual.getTitle().equals(title) && actual.getAuthor().equals(author)) {
                return actual;
            }
        }
        return null;
    }

    public Book findBook(List<Book> books, Book book) {
        for (Book actual: books) {
            if (actual.equals(book)) {
                return actual;
            }
        }
        return null;
    }

    public Set<Book> addBooksToSet(Book[] books) {
        Set<Book> bookSet = new HashSet<>();
        for (Book actual: books) {
            bookSet.add(actual);
        }
        return bookSet;
    }

}
