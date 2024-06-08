package com.example.paskaita_2024_06_06;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class UIManager {
    Button addAnimal;
    Button removeAnimal;

    private List<Animal> animalList;
    TextView animalName;
    TextView animalAge;
    TextView animalSpecies;
    TextView animalListView;

    public UIManager(View rootView) {
        animalList = new ArrayList<>();

        animalListView = rootView.findViewById(R.id.animalListView);
        addAnimal = rootView.findViewById(R.id.addAnimalButton);
        removeAnimal = rootView.findViewById(R.id.removeAnimal);
        animalName = rootView.findViewById(R.id.animalName);
        animalAge = rootView.findViewById(R.id.animalAge);
        animalSpecies = rootView.findViewById(R.id.animalSpecies);
    }

    public void run(){
        addAnimal.setOnClickListener(v -> addAnimal());
        removeAnimal.setOnClickListener(v -> removeAnimal());
    }


    private void addAnimal(){
        Animal animal = createAnimalFromTextFields();
        if (animal != null){
            animalList.add(animal);
            setAnimalListViewTextValues();
        }
        resetTextFieldValues();
    }

    private void removeAnimal(){
        Animal animal = createAnimalFromTextFields();
        if(animal != null){
            animalList.remove(animal);
            setAnimalListViewTextValues();
        }
        resetTextFieldValues();
    }

    private Animal createAnimalFromTextFields(){

        String name = animalName.getText().toString();
        String age = animalAge.getText().toString();
        String species = animalSpecies.getText().toString();

        if(name.isEmpty() || age.isEmpty() || species.isEmpty()) return null;

        try{
            return new Animal(name, Integer.parseInt(age), species);
        }catch (InputMismatchException e){
            return null;
        }

    }
    private void setAnimalListViewTextValues(){
        animalListView.setText(animalListToString());
    }

    private void resetTextFieldValues(){
        animalName.setText("");
        animalAge.setText("");
        animalSpecies.setText("");
    }


    private String animalListToString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Animal a: animalList){
            stringBuilder.append(String.format("%-15s amžius: %3s rūšis: %s \n",a.getVardas(),a.getAmzius(),a.getRusis()));
        }
        return stringBuilder.toString().isEmpty() ? "Gyvūnų sąrašas tuščias!" : stringBuilder.toString();
    }
}
