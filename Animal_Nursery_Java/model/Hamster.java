package model;

import java.time.LocalDate;
import java.util.List;

public class Hamster extends Pet {
    private String creature;

    public Hamster(String type, String creature, String name, LocalDate birthDate, List<String> commands) {
        super(type, name, birthDate, commands);
        this.creature = creature;
    }
    
    public Hamster() {
       
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
        Hamster hamster = (Hamster) obj;
        return (this.creature == hamster.creature && this.name == hamster.name && this.birthDate == hamster.birthDate);
    }
    
    
}
