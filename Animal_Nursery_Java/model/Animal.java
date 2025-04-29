package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
//import java.time.format.DateTimeFormatter;
import java.util.List;

public class Animal {

    protected String name;
    protected LocalDate birthDate;
    protected List<String> commands = new ArrayList<>();

    public Animal(String name, LocalDate birthDate, List<String> commands) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = commands;
    }

    public Animal() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getBirthDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return birthDate.format(formatter);
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void addCommands(String command) {
        commands.add(command);
    }

    public void removeCommand(String command) {
        commands.remove(command);
    }

    

    @Override
    public String toString() {
        return "Animal{" +
                "name: " + name + 
                ", date Of birth: " + getBirthDate() +
                ", commands: " + commands +
                "}";
    }
}

