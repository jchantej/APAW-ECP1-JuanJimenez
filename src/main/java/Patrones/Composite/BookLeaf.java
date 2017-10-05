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
        // not soported because is  leaf
        
    }

    @Override
    public void remove(BookComponent bookComponent) {
        // not soported because is  leaf
        
    }
    
    @Override
    public String toString () {
        
        return  String.valueOf(book.getId());
    }


}
