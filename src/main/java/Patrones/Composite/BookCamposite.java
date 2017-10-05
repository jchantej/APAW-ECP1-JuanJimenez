package Patrones.Composite;

import java.util.ArrayList;
import java.util.List;

public class BookCamposite extends BookComponent{
    
    private List<BookComponent> bookComponents;
    private String nombre;
    
    
    public BookCamposite(String nombre) {
        super();
        this.nombre = nombre;
        this.bookComponents = new ArrayList<>();
    }


    @Override
    public void add(BookComponent bookComponent) {
        assert bookComponent != null;
        bookComponents.add(bookComponent);
        
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
