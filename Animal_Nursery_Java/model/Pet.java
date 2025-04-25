package model;

public class Pet extends Animal{

    protected String type;

    public Pet(String type){
        this.type = type;
    }

    public Pet( ){
        
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
