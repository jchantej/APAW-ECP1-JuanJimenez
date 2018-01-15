package Patrones.Builder;

import Patrones.Mobile;

import java.util.ArrayList;
import java.util.List;


import Patrones.Level;
import Patrones.Persona;


public class PersonaBuilder {
    

    private List<Mobile> mobiles;
    private Level level;
    private Persona persona;
    
    public PersonaBuilder(long id,  Mobile mobile) {
        this.mobiles = new ArrayList<>();
        this.mobiles.add(mobile);
        this.persona = new Persona(id,  mobiles);
    }
    


    public PersonaBuilder() {
        this (0,new Mobile(0,""));
     }
    

    public PersonaBuilder id(long id) {
        this.persona.setId(id);
        return this;
    }
    
    public PersonaBuilder dni(String dni) {
        this.persona.setDni(dni);
        return this;
    }
    
    public PersonaBuilder level(Level level) {
        this.persona.setLevel(level);
        return this;
    }
    
    public PersonaBuilder mobile(Mobile mobile) {
        
        if (this.mobiles == null) {
            this.mobiles = new ArrayList<>();
            this.persona.setMobiles(mobiles);
        }

        this.mobiles.add(mobile);
        return this;
    }
    
    public PersonaBuilder porDefecto() {
        return this.id(1).dni("1104402944").level(level.MEDIUM).mobile(new Mobile()).mobile(new Mobile(2,"Casa"));
    }
    
    
    public Persona build() {
        return this.persona;
    }


}
