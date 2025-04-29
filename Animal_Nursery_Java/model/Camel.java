package model;

import java.time.LocalDate;
import java.util.List;

public class Camel extends Pack_Animal {
    private String creature;

    public Camel(String type, String creature, String name, LocalDate birthDate, List<String> commands) {
        super(type, name, birthDate, commands);
        this.creature = creature;
    }

    public Camel() {
       
    }
    
    public String getCreature() {
        return creature;
    }

    public void setCreature(String creature) {
        this.creature = creature;
    }

    @Override
    public String toString() {
        return  "Type: " + type +
                ",animal: " + creature +
                ", name: " + name + 
                ", date Of birth: " + getBirthDate() +
                ", commands: " + commands +
                "}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
           return true;
        }
        if(this == null || getClass()!= obj.getClass()){
            return false;
        }
        Camel camel = (Camel) obj;
        return (this.creature == camel.creature && this.name == camel.name && this.birthDate == camel.birthDate);
    }

}
