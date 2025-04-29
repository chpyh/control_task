package model;

import java.time.LocalDate;
import java.util.List;

public class Pack_Animal extends Animal {

    protected String type;

    public Pack_Animal(String type, String name, LocalDate birthDate, List<String> commands){
        super(name, birthDate, commands);
        this.type = type;
     
    }

    public Pack_Animal( ){
   
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = "Pet";
    }

    @Override
    public String toString() {
        return "Animal{" + 
                ", type: " + type +
                ", name: " + name +
                ", date Of birth: " + getBirthDate() +
                ", commands: " + commands +
                "}";
    }
    
    
}