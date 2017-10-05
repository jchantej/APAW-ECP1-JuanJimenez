package Patrones.Composite;

import Patrones.Book;

public class BookLeaf extends BookComponent
{

    private Book book;   
    
    public BookLeaf(Book book) {
        super();
        this.book = book;
    }


    @Override
    public String view() {
        
        return this.toString();
    }

    @Override
    public void add(BookComponent bookComponent) {
        throw new UnsupportedOperationException("Operación no soportada");
        
    }

    @Override
    public String toString () {
        
        return  String.valueOf(book.getId());
    }


}
