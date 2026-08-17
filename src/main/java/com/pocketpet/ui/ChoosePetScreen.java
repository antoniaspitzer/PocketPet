package com.pocketpet.ui;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ChoosePetScreen extends AnchorPane {

    public ChoosePetScreen(Runnable onStart) {

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
        // Cat
        // --------------------------

        Image catImage = new Image(
                getClass()
                        .getResource("/images/cat.png")
                        .toExternalForm()
        );

        ImageView cat = new ImageView(catImage);

        cat.setSmooth(false);

        cat.setFitWidth(110);
        cat.setFitHeight(110);

        cat.setLayoutX(265);
        cat.setLayoutY(120);


        // --------------------------
        // Title
        // --------------------------

        Label title = new Label("POCKET PET");

        title.setStyle("""
                -fx-font-size: 32;
                -fx-font-weight: bold;
                """);

        title.setLayoutX(230);
        title.setLayoutY(50);


        // --------------------------
        // Start Button
        // --------------------------

        PixelButton startButton = new PixelButton("START");

        startButton.setLayoutX(250);
        startButton.setLayoutY(270);

        startButton.setOnAction(event -> {
            onStart.run();
        });


        // --------------------------
        // Exit Button
        // --------------------------

        PixelButton exitButton = new PixelButton("EXIT");

        exitButton.setLayoutX(250);
        exitButton.setLayoutY(340);

        exitButton.setOnAction(event -> {
            System.exit(0);
        });


        // --------------------------
        // Add everything
        // --------------------------

        getChildren().addAll(
                frame,
                title,
                cat,
                startButton,
                exitButton
        );
    }
}