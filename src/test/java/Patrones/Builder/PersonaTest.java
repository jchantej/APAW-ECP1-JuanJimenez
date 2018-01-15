package Patrones.Builder;

import static org.junit.Assert.assertEquals;



import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import Patrones.Level;
import Patrones.Mobile;
import Patrones.Persona;

public class PersonaTest {
    
    private Level level;


    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testPersonaBuilder() {
        Mobile mobile1 = new MobileBuilder().id(1).type("Movil").number(2155).build();
        Mobile mobile2 = new MobileBuilder().id(2).type("Fax").number(25645).build();

        Persona persona = new PersonaBuilder().id(1).dni("12121").level(level.BASIC).mobile(mobile1).mobile(mobile2).build();

        assertEquals(1, persona.getId());
        assertEquals("12121", persona.getDni());
        assertEquals(level.BASIC, persona.getLevel());
        System.out.print(persona.getMobiles().get(1).getId());
        assertEquals(1, persona.getMobiles().get(1).getId());
        assertEquals(2, persona.getMobiles().get(2).getId());
        assertEquals("Movil", persona.getMobiles().get(1).getType());
        assertEquals("Fax", persona.getMobiles().get(2).getType());

    }




}
