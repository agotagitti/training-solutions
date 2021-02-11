package collectionscomp;

public class Book implements Comparable<Book> {

    private int regNumber;
    private String title;
    private String author;

    public Book(int regNumber, String title, String author) {
        this.regNumber = regNumber;
        this.title = title;
        this.author = author;
    }

    @Override
    public int compareTo(Book o) {
        return title.compareTo(o.getTitle());
    }

    public int getRegNumber() {
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
                "regNumber=" + regNumber +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

}
