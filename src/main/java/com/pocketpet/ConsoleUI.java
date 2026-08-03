package com.pocketpet;

public class ConsoleUI {
    public static final String RESET = "\u001B[0m";

    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";

    public static final String RED_BACKGROUND = "\u001B[41m";

    public void showPetStatus(Pet pet) {

        System.out.println("------------------");
        System.out.println(pet.getName());
        System.out.println("------------------");

        System.out.println(ConsoleUI.BLUE + "Hunger: " + createBar(pet.getHunger()));
        System.out.println("Happiness: " + createBar(pet.getHappiness()));
        System.out.println("Energy: " + createBar(pet.getEnergy()) + ConsoleUI.RESET);
        System.out.println(ConsoleUI.RED_BACKGROUND + pet.getMessage() + ConsoleUI.RESET);
    }


    private String createBar(int value) {

        int filled = value / 10;

        return "█".repeat(filled)
                + "░".repeat(10 - filled)
                + " " + value + "%";
    }
}
