package Patrones.Factory;

import java.util.HashMap;
import java.util.Map;

import Patrones.Book;

public class BookFactory {

    private static BookFactory bookfactory = new BookFactory();

    private Map<Long, Book> references;

    private BookFactory() {

        this.references = new HashMap<>();

    }

    public static BookFactory getBookfactory() {
        return bookfactory;
    }

    public Book getReference(long key) {
        return this.references.get(key);

    }

    public void setReference(Book book) {
        this.references.put(book.getId(), book);
    }

    public void removeReference(long key) {
        this.references.remove(key);
    }

}
