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
        // Arrow Buttons
        // --------------------------

        PixelArrowKey pixelArrowLeft = new PixelArrowKey("LEFT");

        pixelArrowLeft.setLayoutX(180);
        pixelArrowLeft.setLayoutY(160);


        PixelArrowKey pixelArrowUp = new PixelArrowKey("UP");

        pixelArrowUp.setLayoutX(300);
        pixelArrowUp.setLayoutY(45);


        PixelArrowKey pixelArrowRight = new PixelArrowKey("RIGHT");

        pixelArrowRight.setLayoutX(420);
        pixelArrowRight.setLayoutY(160);


        PixelArrowKey pixelArrowDown = new PixelArrowKey("DOWN");

        pixelArrowDown.setLayoutX(300);
        pixelArrowDown.setLayoutY(265);


        // --------------------------
        // Start Button
        // --------------------------

        PixelButton startButton = new PixelButton("CHOOSE PET");

        startButton.setLayoutX(250);
        startButton.setLayoutY(350);

        startButton.setOnAction(event -> {
            onStart.run();
        });


        // --------------------------
        // Add everything
        // --------------------------

        getChildren().addAll(
                frame,
                cat,
                pixelArrowLeft,
                pixelArrowUp,
                pixelArrowRight,
                pixelArrowDown,
                startButton
        );
    }
}