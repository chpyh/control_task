package model;

import java.time.LocalDate;
import java.util.List;

public class Donkey extends Pack_Animal{
    private String creature;

    public Donkey(String type, int Id, String creature, String name, LocalDate birthDate, List<String> commands) {
        super(type, name, Id, birthDate, commands);
        this.creature = creature;
    }

    public Donkey() {
       
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
        Donkey donkey = (Donkey) obj;
        return (this.creature == donkey.creature && this.name == donkey.name && this.birthDate == donkey.birthDate);
    }
    
}
