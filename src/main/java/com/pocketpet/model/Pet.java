package com.pocketpet.model;

public class Pet {

    private String name;

    private int hunger;
    private int happiness;
    private int energy;

    private String message;

    private PetType type;
    private PetColor color;


    private static final int MAX_VALUE = 100;
    private static final int MIN_VALUE = 0;


    public Pet(String name) {

        this.name = name;

        this.hunger = 50;
        this.happiness = 50;
        this.energy = 100;

        this.message = "Welcome to PocketPet!";

        this.type = PetType.CAT;
        this.color = PetColor.BROWN;
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

    public void setType(PetType type) {
        this.type = type;
    }

    public void setColor(PetColor color) {
        this.color = color;
    }
}