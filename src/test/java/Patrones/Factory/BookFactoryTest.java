package Patrones.Factory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import Patrones.Author;
import Patrones.Book;
import Patrones.Builder.AuthorBuilder;
import Patrones.Builder.BookBuilder;

public class BookFactoryTest {

    private Author authorA;

    private Author authorB;

    private Book bookA;

    private Book bookB;

    @Before
    public void before() {
        authorA = new AuthorBuilder().id(1).name("Juan").build();
        authorB = new  AuthorBuilder().id(2).name("Pablo").build();

    }

    @Test
    public void getValuesReferenceFactoryTest() {

        bookA = new BookBuilder().author(authorA).id(1).build();
        bookB = new BookBuilder().author(authorB).id(2).build();
        BookFactory.getBookfactory().setReference(bookA);
        BookFactory.getBookfactory().setReference(bookB);
        assertSame("Juan", BookFactory.getBookfactory().getReference(1).getAutor().getName());
        assertSame("Pablo", BookFactory.getBookfactory().getReference(2).getAutor().getName());

    }

    @Test
    public void getValuesReferenceNotMatchTest() {

        bookA = new BookBuilder().author(authorA).id(1).build();
        bookB = new BookBuilder().author(authorB).id(2).build();
        BookFactory.getBookfactory().setReference(bookA);
        BookFactory.getBookfactory().setReference(bookB);
        assertNotEquals(BookFactory.getBookfactory().getReference(1), BookFactory.getBookfactory().getReference(2));

    }

    @Test
    public void getValuesReferenceNotRegisterTest() {

        Book bookA = new BookBuilder().author(authorA).id(1).build();
        BookFactory.getBookfactory().setReference(bookA);
        assertNull("No Existe la Referencia", BookFactory.getBookfactory().getReference(2));

    }

    @Test
    public void testIsSingleton() {
        assertSame(BookFactory.getBookfactory(), BookFactory.getBookfactory());
    }

}
