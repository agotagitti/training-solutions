package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class OrderedArrayLibrary {

    private Book[] bookArray;

    public OrderedArrayLibrary(Book[] bookArray) {
        this.bookArray = bookArray;
    }


    public Book[] sortingById() {
        Book[] orderedArray = bookArray;
        Arrays.sort(orderedArray);
        return orderedArray;
    }

    public Book[] sortingByTitle() {
        Book[] orderedArray = bookArray;
        Arrays.sort(orderedArray,
                new Comparator<Book>() {
                    @Override
                    public int compare(Book book1, Book book2) {
                        return book1.getTitle().compareTo(book2.getTitle());
                    }
                });
        return orderedArray;
    }

}
