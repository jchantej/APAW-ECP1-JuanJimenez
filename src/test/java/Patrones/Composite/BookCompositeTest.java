package Patrones.Composite;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Patrones.Author;
import Patrones.Book;
import Patrones.Builder.AuthorBuilder;
import Patrones.Builder.BookBuilder;

public class BookCompositeTest {

    private Book bookA;

    private Book bookB;

    private Book bookC;

    private Author author;

    private BookComponent estante;

    private BookComponent sub1;

    private BookComponent leaf;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void ini() {
        author = new AuthorBuilder().id(1).name("Pablo").build();
        bookA = new BookBuilder().id(2).title("MYSQL").author(author).build();
        bookB = new BookBuilder().id(3).title("JAVA").author(author).build();
        bookC = new BookBuilder().id(4).title("C SHARP").author(author).build();

        this.estante = new BookCamposite("PROGRAMACION");
        this.leaf = new BookLeaf(bookB);
        this.estante.add(leaf);
        this.estante.add(new BookLeaf(bookC));

        this.sub1 = new BookCamposite("BASE DE DATOS");
        this.estante.add(sub1);
        this.sub1.add(new BookLeaf(bookA));

    }

    @Test
    public void testIdBookIfLeaf() {
        assertEquals("3", this.leaf.view());

    }

    @Test
    public void testNameGroupOfBooksIfComposite() {

        assertEquals("PROGRAMACION", this.estante.view());
        assertEquals("BASE DE DATOS", this.sub1.view());
    }


}
