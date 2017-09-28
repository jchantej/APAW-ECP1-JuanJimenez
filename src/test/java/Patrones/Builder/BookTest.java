package Patrones.Builder;

import static org.junit.Assert.assertEquals;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Test;
import Patrones.Author;
import Patrones.Book;

public class BookTest {

    @Test
    public void testBookLongStringCalendarAuthor() {
        Author author = new Author(32, "Juan P", "Español");
        Calendar fechaActual = GregorianCalendar.getInstance();
        Book book = new BookBuilder().id(1).isbn(12).title("Programacion").date(fechaActual).author(author).build();

        assertEquals(1, book.getId());
        assertEquals(12, book.getIsbn());
        assertEquals("Programacion", book.getTitle());
        String formatoFecha = String.valueOf(book.getDate().get(Calendar.DAY_OF_MONTH)) + "/"
                + String.valueOf(book.getDate().get(Calendar.MONTH) + 1) + "/" + String.valueOf(book.getDate().get(Calendar.YEAR));
        assertEquals("29/9/2017", formatoFecha);
        assertEquals(32, book.getAutor().getId());
        assertEquals("Juan P", book.getAutor().getName());
        assertEquals("Español", book.getAutor().getLanguage());

    }

}
