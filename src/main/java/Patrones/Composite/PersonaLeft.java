package Patrones.Composite;

import Patrones.Persona;

public class PersonaLeft extends PersonaComponent {
    
    
    private Persona persona;   
    
    public PersonaLeft(Persona persona) {
        super();
        this.persona = persona;
    }

    @Override
    public String view() {
        
        return this.toString();
    }

    @Override
    public void add(PersonaComponent personaComponent) {
        throw new UnsupportedOperationException("Operación no soportada");
        
    }

    @Override
    public String toString () {
        
        return  String.valueOf(persona.getId());
    }
    





}
