package com.pocketpet.controller;
import java.util.Scanner;

import com.pocketpet.model.Pet;
import com.pocketpet.ui.ConsoleUI;

public class GameController {

    private Pet pet;
    private ConsoleUI ui;

    public GameController(Pet pet, ConsoleUI ui) {
        this.pet = pet;
        this.ui = ui;
    }

    public void start() { 
        Scanner scanner = new Scanner(System.in);

        while (true) {
            ui.showPetStatus(pet);

            System.out.println("What do you wanna do?");
            System.out.println("1 Feed");
            System.out.println("2 Play");
            System.out.println("3 Sleep");
            System.out.println("4 Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    pet.feed();
                    break;
                case 2:
                    pet.play();
                    break;
                case 3:
                    pet.sleep();
                    break;
                case 4:
                    System.out.println("See you!!");
                    return;
                default:
                    System.out.println("Invalid Number!");
            }
        }
    }
}