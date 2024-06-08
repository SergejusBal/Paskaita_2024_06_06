package com.example.paskaita_2024_06_06;

import java.util.Objects;

public class Animal {
    private String vardas;
    private int amzius;
    private String rusis;

    public Animal(String vardas, int amzius, String rusis) {
        this.vardas = vardas;
        this.amzius = amzius;
        this.rusis = rusis;
    }


    public String getVardas() {
        return vardas;
    }

    public int getAmzius() {
        return amzius;
    }

    public String getRusis() {
        return rusis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return amzius == animal.amzius && Objects.equals(vardas, animal.vardas) && Objects.equals(rusis, animal.rusis);
    }


}
