package Patrones.Builder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Patrones.Author;
import Patrones.Mobile;

public class MobileTest {

    @Test
    public void testMobileBuilder() {

        Mobile mobile = new MobileBuilder().id(1).type("Movil").number(125).build();
        assertEquals(1, mobile.getId());
        assertEquals("Movil", mobile.getType());
        assertEquals(125, mobile.getNumber());

    }
    
}
