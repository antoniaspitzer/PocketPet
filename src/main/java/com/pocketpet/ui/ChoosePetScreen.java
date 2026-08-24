package com.pocketpet.ui;

import com.pocketpet.model.Pet;
import com.pocketpet.model.PetColor;
import com.pocketpet.model.PetType;
import com.pocketpet.util.PetImageManager;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.function.Consumer;

public class ChoosePetScreen extends AnchorPane {

    private Pet pet;
    private ImageView petImage;


    public ChoosePetScreen(Pet pet, Consumer<Pet> onStart) {

        this.pet = pet;


        // --------------------------
        // Background
        // --------------------------

        Image frameImage = new Image(
                getClass()
                        .getResource("/images/frame.png")
                        .toExternalForm()
        );

        ImageView frame = new ImageView(frameImage);

        frame.setSmooth(false);
        frame.setFitWidth(640);
        frame.setFitHeight(480);


        // --------------------------
        // Pet Image
        // --------------------------

        petImage = new ImageView(
                PetImageManager.getPetImage(
                        pet.getType(),
                        pet.getColor()
                )
        );

        petImage.setSmooth(false);

        petImage.setFitWidth(110);
        petImage.setFitHeight(110);

        petImage.setLayoutX(265);
        petImage.setLayoutY(120);


        // --------------------------
        // Arrow Buttons
        // --------------------------

        PixelArrowKey pixelArrowLeft = new PixelArrowKey("LEFT");

        pixelArrowLeft.setLayoutX(180);
        pixelArrowLeft.setLayoutY(160);

        pixelArrowLeft.setOnAction(event -> {

            changeColor(-1);

        });


        PixelArrowKey pixelArrowUp = new PixelArrowKey("UP");

        pixelArrowUp.setLayoutX(300);
        pixelArrowUp.setLayoutY(45);

        pixelArrowUp.setOnAction(event -> {

            changePetType(-1);

        });


        PixelArrowKey pixelArrowRight = new PixelArrowKey("RIGHT");

        pixelArrowRight.setLayoutX(420);
        pixelArrowRight.setLayoutY(160);

        pixelArrowRight.setOnAction(event -> {

            changeColor(1);

        });


        PixelArrowKey pixelArrowDown = new PixelArrowKey("DOWN");

        pixelArrowDown.setLayoutX(300);
        pixelArrowDown.setLayoutY(265);

        pixelArrowDown.setOnAction(event -> {

            changePetType(1);

        });


        // --------------------------
        // Start Button
        // --------------------------

        PixelButton startButton = new PixelButton("CHOOSE PET");

        startButton.setLayoutX(250);
        startButton.setLayoutY(350);

        startButton.setOnAction(event -> {

            onStart.accept(pet);

        });


        // --------------------------
        // Add everything
        // --------------------------

        getChildren().addAll(
                frame,
                petImage,

                pixelArrowLeft,
                pixelArrowUp,
                pixelArrowRight,
                pixelArrowDown,

                startButton
        );
    }


    // --------------------------
    // Change Color
    // --------------------------

    private void changeColor(int direction) {

        PetColor[] colors = PetColor.values();

        int currentIndex = pet.getColor().ordinal();

        int newIndex = currentIndex + direction;


        // Wenn wir links über den Anfang hinausgehen
        if (newIndex < 0) {
            newIndex = colors.length - 1;
        }

        // Wenn wir rechts über das Ende hinausgehen
        if (newIndex >= colors.length) {
            newIndex = 0;
        }


        pet.setColor(colors[newIndex]);

        updatePetImage();
    }


    // --------------------------
    // Change Pet Type
    // --------------------------

    private void changePetType(int direction) {

        PetType[] types = PetType.values();

        int currentIndex = pet.getType().ordinal();

        int newIndex = currentIndex + direction;


        // Wenn wir oben über den Anfang hinausgehen
        if (newIndex < 0) {
            newIndex = types.length - 1;
        }

        // Wenn wir unten über das Ende hinausgehen
        if (newIndex >= types.length) {
            newIndex = 0;
        }


        pet.setType(types[newIndex]);

        updatePetImage();
    }


    // --------------------------
    // Update Pet Image
    // --------------------------

    private void updatePetImage() {

        petImage.setImage(
                PetImageManager.getPetImage(
                        pet.getType(),
                        pet.getColor()
                )
        );
    }
}