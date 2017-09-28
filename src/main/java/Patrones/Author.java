package Patrones;

public class Author {

    private long id;

    private String name;

    private String language;

    public Author(Long id, String name, String language) {
        super();
        this.id = id;
        this.name = name;
        this.language = language;
    }
    
    public Author(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
