package $08InputOutput.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Dmitrii on 24.06.2018.
 */
public class TestSorted {
    public static class Book {
        String isbn;
        String title;

        public Book(String isbn, String title) {
            this.isbn = isbn;
            this.title = title;
        }
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("123", "Big Bang"));
        books.add(new Book("233", "New"));
        // Collections.sort(books); book is not a Comparable, compilation failure

        List list = (List) books;
        Collections.sort(list); // Exception in compile time: ClassCastException: Book cannot be cast to java.lang.Comparable

        books.stream().sorted().forEach(b->System.out.println(b.isbn)); // ClassCastException
        // cast to comparable happens in runtime
        // Exception in thread "main" java.lang.ClassCastException: $08InputOutput.streams.TestSorted$Book cannot be cast to java.lang.Comparable
    }
}
