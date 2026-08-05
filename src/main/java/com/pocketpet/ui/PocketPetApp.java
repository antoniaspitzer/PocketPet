package com.pocketpet.ui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PocketPetApp extends Application {

    @Override
    public void start(Stage stage) {

        // --------------------------
        // Background
        // --------------------------

        Image frameImage = new Image(
                getClass().getResource("/images/frame.png").toExternalForm());

        ImageView frame = new ImageView(frameImage);
        frame.setSmooth(false);
        frame.setFitWidth(640);
        frame.setFitHeight(480);

        // --------------------------
        // Cat
        // --------------------------

        Image catImage = new Image(
                getClass().getResource("/images/cat.png").toExternalForm());

        ImageView cat = new ImageView(catImage);

        cat.setSmooth(false);
        cat.setFitWidth(110);
        cat.setFitHeight(110);

        // Position im oberen Bereich
        cat.setLayoutX(265);
        cat.setLayoutY(35);

        // --------------------------
        // Name
        // --------------------------

        Label petName = new Label("Momo");

        petName.setStyle("""
                -fx-font-size: 22;
                -fx-font-weight: bold;
                """);

        petName.setLayoutX(290);
        petName.setLayoutY(150);

        // --------------------------
        // Progress Bars
        // --------------------------

        PixelProgressBar hunger = new PixelProgressBar();

        hunger.setValue(15);

        hunger.setLayoutX(200);
        hunger.setLayoutY(200);

        // --------------------------
        // Game Pane
        // --------------------------

        AnchorPane game = new AnchorPane();

        game.getChildren().addAll(
                cat,
                petName,

                hunger

        );

        // --------------------------
        // Root
        // --------------------------

        StackPane root = new StackPane(frame, game);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 640, 480);

        stage.setTitle("PocketPet");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}