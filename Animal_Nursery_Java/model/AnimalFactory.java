package model;

import java.time.LocalDate;
import java.util.List;

public class AnimalFactory {

    public static Animal careateAnimal(String creature, String type, String name, LocalDate birthDate, List<String> commands){

        if(creature.equalsIgnoreCase("cat")){
            return new Cat(creature, type, name, birthDate, commands);
        } else if(creature.equalsIgnoreCase("dog")){
            return new Dog(creature, type, name, birthDate, commands);
        }else if(creature.equalsIgnoreCase("hamster")){
            return new Hamster(creature, type, name, birthDate, commands);
        }else if(creature.equalsIgnoreCase("camel")){
            return new Camel(creature, type, name, birthDate, commands);
        }else if(creature.equalsIgnoreCase("donkey")){
            return new Hamster(creature, type, name, birthDate, commands);
        }else{
        return null;
        }
    
    }
}
