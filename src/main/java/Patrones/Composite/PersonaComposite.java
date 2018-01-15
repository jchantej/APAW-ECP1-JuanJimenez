package Patrones.Composite;

import java.util.ArrayList;
import java.util.List;

public class PersonaComposite extends PersonaComponent {
    
    private List<PersonaComponent> personasComponents;
    private String nombre;
    
    
    public PersonaComposite(String nombre) {
        super();
        this.nombre = nombre;
        this.personasComponents = new ArrayList<>();
    }
    

    @Override
    public void add(PersonaComponent personaComponent) {
        assert personaComponent != null;
        personasComponents.add(personaComponent);
        
    }


    @Override
    public String view() {
        return this.toString();
    }
    
    
    @Override
    public String toString() {
        return this.nombre;
    }



}
