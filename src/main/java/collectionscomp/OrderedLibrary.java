package collectionscomp;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class OrderedLibrary {

    private List<Book> libraryBooks;

    public OrderedLibrary(List<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public List<Book> orderedByTitle() {
        List<Book> booksByTitle = new ArrayList<>(libraryBooks);
        Collections.sort(booksByTitle);
        return booksByTitle;
    }

    public List<Book> orderedByAuthor() {
        List<Book> booksByAuthor = new ArrayList<>(libraryBooks);
        Collections.sort(booksByAuthor, new AuthorComparator());
        return booksByAuthor;
    }

    public List<String> orderedByTitleLocale(Locale locale) {
        List<String> bookTitles = new ArrayList<>();
        for (Book actual : libraryBooks) {
            bookTitles.add(actual.getTitle());
        }
        Collections.sort(bookTitles, Collator.getInstance(locale));
        return bookTitles;
    }

}
