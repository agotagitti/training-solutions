package collectionsiterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LibraryManager {

    Set<Book> libraryBooks;

    public LibraryManager(Set<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public Book findBookByRegNumber(int regNumber) {
        Iterator<Book> iterator = libraryBooks.iterator();
        while (iterator.hasNext()) {
            Book foundBook = iterator.next();
            if (foundBook.getRegNumber() == regNumber) {
                return foundBook;
            }
        }
        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }

    public int removeBookByRegNumber(int regNumber) {
        Iterator<Book> iterator = libraryBooks.iterator();
        while(iterator.hasNext()) {
            if (iterator.next().getRegNumber() == regNumber) {
                iterator.remove();
                return regNumber;
            }
        }
        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }

    public Set<Book> selectBooksByAuthor(String author) {
        Set<Book> foundBooks = new HashSet<>();
        Iterator<Book> iterator = libraryBooks.iterator();
        while(iterator.hasNext()) {
            Book foundBook = iterator.next();
            if (foundBook.getAuthor().equals(author)) {
                foundBooks.add(foundBook);
            }
        }
        if (foundBooks.isEmpty()) {
            throw new MissingBookException("No books found by " + author);
        }
        return foundBooks;
    }

    public int libraryBooksCount() {
        return libraryBooks.size();
    }
}
