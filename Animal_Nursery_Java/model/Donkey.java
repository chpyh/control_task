package model;

public class Donkey extends Pack_Animal{
    private String creature;

    public Donkey(String type, String creature) {
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
