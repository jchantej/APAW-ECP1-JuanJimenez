package Patrones;

import java.util.List;

public class Persona {
    
    private long id;
    private String dni;
    private Level level;
    private List<Mobile> mobiles;
    

    public Persona(long id, List<Mobile> mobiles) {
        super();
        this.id = id;
        this.mobiles = mobiles;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public Level getLevel() {
        return level;
    }
    public void setLevel(Level level) {
        this.level = level;
    }
    public List<Mobile> getMobiles() {
        return mobiles;
    }
    public void setMobiles(List<Mobile> mobiles) {
        this.mobiles = mobiles;
    }

    
    

}
