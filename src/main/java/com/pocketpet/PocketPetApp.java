package com.pocketpet;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;


public class PocketPetApp extends Application {

    @Override
    public void start(Stage stage) {

        Image frameImage = new Image(
                getClass().getResource("/images/frame.png").toExternalForm()
        );

        ImageView frame = new ImageView(frameImage);

        frame.setSmooth(false);

        frame.setFitWidth(640);
        frame.setFitHeight(480);

        // UI Elemente

        Label name = new Label("Momo 🐱");

        ProgressBar hunger = new ProgressBar(0.5);
        ProgressBar happiness = new ProgressBar(0.5);
        ProgressBar energy = new ProgressBar(1.0);

        hunger.setPrefWidth(200);
        happiness.setPrefWidth(200);
        energy.setPrefWidth(200);


        Button feedButton = new Button("🍎 Feed");
        Button playButton = new Button("🎾 Play");
        Button sleepButton = new Button("🌙 Sleep");


        VBox ui = new VBox(
                10,
                name,

                new Label("Hunger"),
                hunger,

                new Label("Happiness"),
                happiness,

                new Label("Energy"),
                energy,

                feedButton,
                playButton,
                sleepButton
        );

        ui.setAlignment(Pos.CENTER);


        // Hintergrund + UI übereinander
        StackPane root = new StackPane();

        root.getChildren().add(frame);
        root.getChildren().add(ui);


        Scene scene = new Scene(root, 640, 480);


        stage.setTitle("PocketPet 🐾");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}