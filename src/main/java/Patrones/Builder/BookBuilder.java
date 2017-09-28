package Patrones.Builder;

import java.util.Calendar;

import Patrones.Author;
import Patrones.Book;

public class BookBuilder {

    private Book book;

    public BookBuilder() {
        book = new Book(0, 0, "");
    }
    
    public BookBuilder(long id, long isbn, String title, Calendar date, Author autor) {

        this.book = new Book(id, isbn, title, date, autor);
    }

    public BookBuilder id(long id) {

        this.book.setId(id);
        return this; // Preguntar por que this
    }

    public BookBuilder isbn(long isbn) {

        this.book.setIsbn(isbn);
        return this;
    }

    public BookBuilder title(String title) {

        this.book.setTitle(title);
        return this;
    }

    public BookBuilder date(Calendar date) {

        this.book.setDate(date);
        return this;
    }

    public BookBuilder author(Author author) {

        this.book.setAutor(author);
        return this;
    }

    public Book build() {
        return this.book;
    }
}
