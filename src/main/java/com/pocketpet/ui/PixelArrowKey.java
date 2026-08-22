package com.pocketpet.ui;

import javafx.scene.control.Button;
import javafx.scene.image.Image;

public class PixelArrowKey extends Button {

    private final Image standardButton = new Image(
        getClass() 
            .getResource("/images/functional/arrow-button-standart.png")
            .toExternalForm()
    );

    private final Image pressedButton = new Image(
        getClass()
            .getResource("/images/functional/arrow-button-onclick.png")
            .toExternalForm()
    );

    private String direction;

    public PixelArrowKey(String direction) {
        this.direction = direction;


        setPrefWidth(48);
        setPrefHeight(80);

                // Normaler Button
        setStyle(
            "-fx-background-image: url('" + standardButton.getUrl() + "');" +
            "-fx-background-size: 100% 100%;" +
            "-fx-background-repeat: no-repeat;" +
            "-fx-background-color: transparent;" +
            "-fx-text-fill: white;"
        );

        // Wenn der Button gedrückt wird
        setOnMousePressed(event -> {

            setStyle(
                "-fx-background-image: url('" + pressedButton.getUrl() + "');" +
                "-fx-background-size: 100% 100%;" +
                "-fx-background-repeat: no-repeat;" +
                "-fx-background-color: transparent;" +
                "-fx-text-fill: white;"
            );
        });

        // Wenn man loslässt
        setOnMouseReleased(event -> {

            setStyle(
                "-fx-background-image: url('" + standardButton.getUrl() + "');" +
                "-fx-background-size: 100% 100%;" +
                "-fx-background-repeat: no-repeat;" +
                "-fx-background-color: transparent;" +
                "-fx-text-fill: white;"
            );
        });

        switch(direction) {
            case "LEFT": 
                break;
            case "UP":
                setRotate(90);
                break;
            case "RIGHT":
                setScaleX(-1);
                setScaleX(-1);
                break;
            case "DOWN":
                setRotate(-90);
                break;
        }
    }
}