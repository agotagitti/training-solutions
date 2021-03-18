package sorting;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class OrderedLibrary {

    private Set<Book> library = new TreeSet<>();

    public OrderedLibrary(Set<Book> library) {
        this.library = library;
    }

    public Book lendFirstBook() {
        if (library.isEmpty()) {
            throw new NullPointerException("Library is empty!");
        }
        Iterator<Book> iterator = library.iterator();
        return iterator.next();
    }

    public Set<Book> getLibrary() {
        return library;
    }

}
