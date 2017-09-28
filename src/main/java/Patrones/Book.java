package Patrones;

import java.util.Calendar;

public class Book {

    private long id;

    private long isbn;

    private String title;

    private Calendar date;

    private Author autor;

    public Book(long id, long isbn, String title, Calendar date, Author autor) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.date = date;
        this.autor = autor;
    }

    public Book(long id, long isbn, String title, Calendar date) {
        super();
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.date = date;
    }

    public Book(long id, long isbn, String title) {
        super();
        this.id = id;
        this.isbn = isbn;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Author getAutor() {
        return autor;
    }

    public void setAutor(Author autor) {
        this.autor = autor;
    }
    
    

}
