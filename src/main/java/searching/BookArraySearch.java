package searching;


import java.util.Arrays;

public class BookArraySearch {

    private Book[] books;

    public BookArraySearch(Book[] books) {
        this.books = books;
    }

    public Book findBookByAuthorTitle(String author, String title) {
        if (isEmpty(author) || isEmpty(title)) {
            throw new IllegalArgumentException("Author or title must not be empty!");
        }
        Book result = new Book(author, title);
        Arrays.sort(books);
        int index = Arrays.binarySearch(books, result);
        if (index < 0) {
            throw new IllegalArgumentException("No book found by " + author + " with title " + title);
        }
        return books[index];
    }

    public boolean isEmpty(String string) {
        return string == null || "".equals(string.trim());
    }

}
