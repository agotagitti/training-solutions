package attributes.book;

import org.w3c.dom.ls.LSOutput;

public class BookMain {

    public static void main(String[] args) {
        Book book1 = new Book("The Dark Tower");
        System.out.println(book1.getTitle());

        book1.setTitle("The Shining");
        System.out.println(book1.getTitle());

    }
}
