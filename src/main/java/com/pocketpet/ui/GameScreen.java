package com.pocketpet.ui;

import com.pocketpet.controller.GameController;
import com.pocketpet.model.Pet;
import com.pocketpet.util.PetImageManager;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class GameScreen extends StackPane {

    private PixelProgressBar hungerBar;
    private PixelProgressBar happinessBar;
    private PixelProgressBar energyBar;

    private Label messageLabel;

    private GameController controller;

    private Pet pet;

    public GameScreen(Pet pet, Runnable onPlay) {

        // --------------------------
        // Create Pet + Controller
        // --------------------------

        controller = new GameController(pet);


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
        // Pet
        // --------------------------

        ImageView petImage = new ImageView(
                PetImageManager.getPetImage(
                        pet.getType(),
                        pet.getColor()
                )
        );

        petImage.setSmooth(false);

        petImage.setFitWidth(110);
        petImage.setFitHeight(110);

        petImage.setLayoutX(265);
        petImage.setLayoutY(35);


        // --------------------------
        // Pet Name
        // --------------------------

        Label petName = new Label(pet.getName());

        petName.setStyle("""
                -fx-font-size: 22;
                -fx-font-weight: bold;
                """);

        petName.setLayoutX(290);
        petName.setLayoutY(150);


        // --------------------------
        // Hunger
        // --------------------------

        Label hungerLabel = new Label("Hunger");

        hungerLabel.setLayoutX(100);
        hungerLabel.setLayoutY(200);

        hungerBar = new PixelProgressBar();

        hungerBar.setLayoutX(200);
        hungerBar.setLayoutY(200);


        // --------------------------
        // Happiness
        // --------------------------

        Label happinessLabel = new Label("Happiness");

        happinessLabel.setLayoutX(100);
        happinessLabel.setLayoutY(250);

        happinessBar = new PixelProgressBar();

        happinessBar.setLayoutX(200);
        happinessBar.setLayoutY(250);


        // --------------------------
        // Energy
        // --------------------------

        Label energyLabel = new Label("Energy");

        energyLabel.setLayoutX(100);
        energyLabel.setLayoutY(300);

        energyBar = new PixelProgressBar();

        energyBar.setLayoutX(200);
        energyBar.setLayoutY(300);


        // --------------------------
        // Message
        // --------------------------

        messageLabel = new Label();

        messageLabel.setLayoutX(100);
        messageLabel.setLayoutY(340);

        messageLabel.setStyle("""
                -fx-font-size: 16;
                """);

        messageLabel.setWrapText(true);
        messageLabel.setPrefWidth(440);


        // --------------------------
        // Buttons
        // --------------------------

        PixelButton feedButton = new PixelButton("Feed");

        feedButton.setLayoutX(100);
        feedButton.setLayoutY(400);

        feedButton.setOnAction(event -> {

            controller.feedPet();

            updateUI();
        });


        PixelButton playButton = new PixelButton("Play");

        playButton.setLayoutX(270);
        playButton.setLayoutY(400);

        playButton.setOnAction(event -> {

            onPlay.run();
            
        });


        PixelButton sleepButton = new PixelButton("Sleep");

        sleepButton.setLayoutX(440);
        sleepButton.setLayoutY(400);

        sleepButton.setOnAction(event -> {

            controller.putPetToSleep();

            updateUI();
        });


        // --------------------------
        // Initial UI Update
        // --------------------------

        updateUI();


        // --------------------------
        // Game Pane
        // --------------------------

        AnchorPane game = new AnchorPane();

        game.getChildren().addAll(

                petImage,
                petName,

                hungerLabel,
                hungerBar,

                happinessLabel,
                happinessBar,

                energyLabel,
                energyBar,

                messageLabel,

                feedButton,
                playButton,
                sleepButton
        );


        // --------------------------
        // Root
        // --------------------------

        getChildren().addAll(frame, game);

        setAlignment(Pos.CENTER);
    }


    // --------------------------
    // Update UI
    // --------------------------

    private void updateUI() {

        Pet pet = controller.getPet();

        // Update bars
        hungerBar.setValue(pet.getHunger());

        happinessBar.setValue(pet.getHappiness());

        energyBar.setValue(pet.getEnergy());

        // Update message
        messageLabel.setText(pet.getMessage());
    }
}