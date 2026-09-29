package com.pocketpet.model;

import javafx.scene.image.ImageView;

public class Food extends ImageView {

    private String path;

    private String message;


    public Pet(String path, String name) {
        this.path = path;
        this.name = name;

        this.message = "";
    }

    // Creating an imageview

    private ImageView createFood(String path) {

        Image image = new Image(
                getClass()
                        .getResource(path)
                        .toExternalForm()
        );

        ImageView food = new ImageView(image);

        food.setSmooth(false);

        food.setFitWidth(50);
        food.setFitHeight(50);

        return food;
    }

    // --------------------------
    // Click events
    // --------------------------
    
    public void eat() {
        this.message = pet.getName() + " ate the " + this.name;
    }


    // --------------------------
    // Pet Actions
    // --------------------------

    public void feed() {

        if (hunger >= MAX_VALUE) {
            message = name + " is already full! They don't want to eat!";
            return;
        }

        hunger = Math.min(MAX_VALUE, hunger + 20);
        happiness = Math.min(MAX_VALUE, happiness + 5);

        message = name + " enjoyed the meal!";
    }


    public void play() {

        if (happiness >= MAX_VALUE) {
            message = name + " is already happy! They don't want to play!";
            return;
        }

        happiness = Math.min(MAX_VALUE, happiness + 15);
        energy = Math.max(MIN_VALUE, energy - 20);
        hunger = Math.max(MIN_VALUE, hunger - 10);

        message = name + " loved playing with you!";
    }


    public void sleep() {

        if (energy >= MAX_VALUE) {
            message = name + "'s energy is already full! They don't want to sleep!";
            return;
        }

        energy = Math.min(MAX_VALUE, energy + 30);
        hunger = Math.max(MIN_VALUE, hunger - 30);
        happiness = Math.max(MIN_VALUE, happiness - 15);

        message = name + " had a good night's sleep!";
    }


    // --------------------------
    // GETTERS
    // --------------------------

    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getEnergy() {
        return energy;
    }

    public String getMessage() {
        return message;
    }

    public PetType getType() {
        return type;
    }

    public PetColor getColor() {
        return color;
    }


    // --------------------------
    // SETTERS
    // --------------------------

    public void setHappiness(int happiness) {
        this.happiness = Math.max(MIN_VALUE, Math.min(MAX_VALUE, happiness));
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public void setColor(PetColor color) {
        this.color = color;
    }
}