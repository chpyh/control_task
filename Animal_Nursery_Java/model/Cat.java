package model;

public class Cat extends Pet{

    private String creature;


    public Cat(String type, String creature) {
        super(type);
        this.creature = creature;
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
    
}
    
