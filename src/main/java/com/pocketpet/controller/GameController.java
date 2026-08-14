package com.pocketpet.controller;

import com.pocketpet.model.Pet;

public class GameController {

    private Pet pet;

    public GameController(Pet pet) {
        this.pet = pet;
    }

    public void feedPet() {
        pet.feed();
    }

    public void playWithPet() {
        pet.play();
    }

    public void putPetToSleep() {
        pet.sleep();
    }

    public Pet getPet() {
        return pet;
    }
}