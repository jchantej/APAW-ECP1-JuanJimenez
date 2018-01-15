package Patrones;

public class Mobile {
    
    private long id;
    private String type;
    private int number;
    
    public Mobile() {

    }
    
    public Mobile(long id, String type) {
        super();
        this.id = id;
        this.type = type;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

}
