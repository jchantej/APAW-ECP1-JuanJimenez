package Patrones.Builder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Patrones.Author;

public class AuthorTest {

    @Test
    public void testAuthorLongStringString() {

        Author author = new AuthorBuilder().id(1).name("Pablo Jimenez").language("Español").build();
        assertEquals(1, author.getId());
        assertEquals("Pablo Jimenez", author.getName());
        assertEquals("Español", author.getLanguage());

    }
    
    @Test
    public void testAuthorLongString() {

        Author author = new AuthorBuilder().id(2).name("Pablo Jimenez").language("Español").build();
        assertEquals(2, author.getId());
        assertEquals("Pablo Jimenez", author.getName());


    }

}
