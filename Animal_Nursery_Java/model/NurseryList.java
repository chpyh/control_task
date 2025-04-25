package model;

import java.util.ArrayList;
import java.util.List;

public class NurseryList {

    private List<Animal> animalList = new ArrayList<>();

    public NurseryList(List<Animal> animalList) {

        this.animalList = animalList;
    }

    public NurseryList() {

    }

    public void setAnimalList(Animal animal) {
        animalList.add(animal);

    }

    public List<Animal> getAnimalList() {
        return animalList;
    }


    @Override
    public String toString() {
        return "Animals: of nursery" + animalList;

    }

}