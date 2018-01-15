package Patrones.Builder;

import Patrones.Mobile;

public class MobileBuilder {
    
    private Mobile mobile;

    public MobileBuilder() {
        this.mobile = new Mobile();
    }
    
    public MobileBuilder id(long id) {

        this.mobile.setId(id);
        return this; 
    }


    public MobileBuilder type(String type) {

        this.mobile.setType(type);
        return this;
    }
    
    public MobileBuilder number(int number) {

        this.mobile.setNumber(number);
        return this;
    }
    

    public Mobile build() {
        return this.mobile;
    }
    

}
