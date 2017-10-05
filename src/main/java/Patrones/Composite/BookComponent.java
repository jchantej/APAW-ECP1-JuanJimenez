package Patrones.Composite;



public abstract class BookComponent {

    public abstract void add(BookComponent bookComponent);  
    public abstract void remove(BookComponent bookComponent);
    public abstract String view();
}
