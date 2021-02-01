package collectionsequalshash;

import java.util.Objects;

public class Book {

    private String regNumber;
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book(String regNumber, String title, String author) {
        this.regNumber = regNumber;
        this.title = title;
        this.author = author;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "regNumber='" + regNumber + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        if (Objects.equals(title, book.title) && Objects.equals(author, book.author)) {
            if (book.regNumber == null || this.regNumber == null || Objects.equals(regNumber, book.regNumber)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNumber, title, author);
    }
}
