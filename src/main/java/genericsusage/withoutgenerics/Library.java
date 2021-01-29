package genericsusage.withoutgenerics;

import genericsusage.Book;

import java.util.List;

public class Library {

    public Book getFirstBook(List books) {
        if (books == null) {
            throw new NullPointerException("Collection is null");
        } else if (books.isEmpty()) {
            throw new IllegalArgumentException("Argument should not be empty!");
        }
        Object object = books.get(0);
        if (!(object instanceof Book)) {
            throw new ClassCastException("Not a book");
        }
        return (Book) object;
    }

}
