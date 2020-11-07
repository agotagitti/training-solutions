package objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectsMain {

    public static void main(String[] args) {

        new Book();

        System.out.println(new Book());

        //System.out.println(Book emptyBook);

        Book emptyBook = null;

        System.out.println(emptyBook);

        if (emptyBook == null) {
            System.out.println("emptyBook is null");
        }

        Book book = new Book();

        System.out.println(book);

        book = null;

        System.out.println(book);

        book = new Book();

        System.out.println(book);

        Book anotherBook = new Book();

        System.out.println(book == anotherBook);

        anotherBook = book;

        System.out.println(anotherBook);
        System.out.println(book);

        System.out.println(book == anotherBook);

        System.out.println(anotherBook instanceof Book);

        //objektumok száma teszt

        Book test1 = new Book();
        Book test2 = test1;

        test2 = null;

        System.out.println(test1);
        System.out.println(test2);

        //tömbök és kollekciók

        Book[] bookArray = {new Book(), new Book(), new Book()};
        List<Book> bookCollection = Arrays.asList(new Book(), new Book(), new Book());
        List<Book> empty = new ArrayList<>();
        empty.add(new Book());
        empty.add(new Book());
        empty.add(new Book());


    }
}
