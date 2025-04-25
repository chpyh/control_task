package model;

public class Pack_Animal extends Animal {

    protected String type;

    public Pack_Animal(String type){
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