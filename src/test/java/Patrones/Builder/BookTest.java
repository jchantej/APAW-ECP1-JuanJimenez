package Patrones.Builder;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Patrones.Author;
import Patrones.Book;

public class BookTest {

    Calendar fechaTest = GregorianCalendar.getInstance();
    String fechaTestFormat = String.valueOf(fechaTest.get(Calendar.DAY_OF_MONTH)) + "/" + String.valueOf(fechaTest.get(Calendar.MONTH) + 1)
            + "/" + String.valueOf(fechaTest.get(Calendar.YEAR));
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testBookLongStringCalendarAuthor() {
        Author author = new AuthorBuilder().id(32).name("Juan Jimenez").language("Español").build();
        Calendar fechaActual = GregorianCalendar.getInstance();
        Book book = new BookBuilder().id(1).isbn(12).title("Programacion").date(fechaActual).author(author).build();

        assertEquals(1, book.getId());
        assertEquals(12, book.getIsbn());
        assertEquals("Programacion", book.getTitle());
        String formatoFecha = String.valueOf(book.getDate().get(Calendar.DAY_OF_MONTH)) + "/"
                + String.valueOf(book.getDate().get(Calendar.MONTH) + 1) + "/" + String.valueOf(book.getDate().get(Calendar.YEAR));
        assertEquals(fechaTestFormat, formatoFecha);
        assertEquals(32, book.getAutor().getId());
        assertEquals("Juan Jimenez", book.getAutor().getName());
        assertEquals("Español", book.getAutor().getLanguage());

    }

    @Test
    public void testBookLongStringCalendar() {
        Calendar fechaActual = GregorianCalendar.getInstance();
        Book book = new BookBuilder().id(1).isbn(12).title("Programacion").date(fechaActual).build();
        assertEquals(1, book.getId());
        assertEquals(12, book.getIsbn());
        assertEquals("Programacion", book.getTitle());
        String formatoFecha = String.valueOf(book.getDate().get(Calendar.DAY_OF_MONTH)) + "/"
                + String.valueOf(book.getDate().get(Calendar.MONTH) + 1) + "/" + String.valueOf(book.getDate().get(Calendar.YEAR));
        assertEquals(fechaTestFormat, formatoFecha);
    }

    @Test
    public void testBookContainsNullAuthor()  {
         Book book = new BookBuilder().author(null).build();
         exception.expect(NullPointerException.class);
         assertEquals(0, book.getAutor().getId());

    }
    
    @Test
    public void testDefaultBookValues()  {
         Book book = new BookBuilder().build();
         assertEquals(0, book.getId());
         assertEquals(0, book.getAutor().getId());
         assertEquals("", book.getAutor().getName());

    }



}
