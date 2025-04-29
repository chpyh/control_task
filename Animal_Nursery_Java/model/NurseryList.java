package model;

import java.util.ArrayList;
import java.util.List;

public class  NurseryList<T>{

    private List<T> animalList = new ArrayList<>();

    public NurseryList(List<T> animalList) {

        this.animalList = animalList;
    }

    public NurseryList() {

    }

    public void setAnimalList(T animal) {
        animalList.add(animal);

    }

    public List<T> getAnimalList() {
        return animalList;
    }


    public int getAnimalListLength(){
        return animalList.size();
    }

    @Override
    public String toString() {
        return "" + animalList;

    }

}