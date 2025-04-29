package model;

import java.time.LocalDate;
import java.util.List;


public class Cat extends Pet{

    private String creature;


    public Cat(String type, String creature, String name, LocalDate birthDate, List<String> commands) {
        super(type, name, birthDate, commands);
        this.creature = creature;
    }
    
    public Cat() {
       
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
        Cat cat = (Cat) obj;
        return (this.creature == cat.creature && this.name == cat.name && this.birthDate == cat.birthDate);
    }
}
 
