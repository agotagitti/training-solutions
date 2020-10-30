package classstructureconstructors;

public class BookMain {

    public static void main(String[] args) {
        Book book = new Book("Stephen King","The Dark Tower");
        book.register("1982");

        System.out.println("Author: " + book.getAuthor());
        System.out.println("Book: " + book.getTitle());
        System.out.println("Registration number: " + book.getRegNumber());

    }

}
