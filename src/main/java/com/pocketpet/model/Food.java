package com.pocketpet.model;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import com.pocketpet.model.Pet;

// ------------------------
// TODO: Anzeige vo Message numoi ändern
// ------------------------

public class Food extends ImageView {

    private String path; // path to the image
    private String message;

    private String name; // the food name, like for example "strawberry"


    public Food(String path, String name) {
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
    
    public void eat(Pet pet) {
        this.message = pet.getName() + " ate the " + this.name;
    }
}