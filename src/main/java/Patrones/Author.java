package Patrones;

public class Author {

    private long id;

    private String name;

    private String language;
    
    public Author() {

    }
    
    public Author(long id, String name, String language) {
        super();
        this.id = id;
        this.name = name;
        this.language = language;
    }
    
    public Author(long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

}
