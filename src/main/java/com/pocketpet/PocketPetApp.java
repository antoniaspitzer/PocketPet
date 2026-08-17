package com.pocketpet;

import com.pocketpet.ui.GameScreen;
import com.pocketpet.ui.ChoosePetScreen;
import com.pocketpet.ui.StartScreen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PocketPetApp extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) {

        this.stage = stage;

        showStartScreen();

        stage.setTitle("PocketPet");
        stage.setResizable(false);

        stage.show();
    }


    // --------------------------
    // Start Screen
    // --------------------------

    private void showStartScreen() {

        StartScreen startScreen = new StartScreen(() -> {
            showChoosePetScreen();
        });

        Scene scene = new Scene(startScreen, 640, 480);

        stage.setScene(scene);
    }

    // -------------------------
    // ChoosePetScreen.java
    // ------------------------

    private void showChoosePetScreen() {
        ChoosePetScreen petScreen = new ChoosePetScreen(() -> {
            showGameScreen();
        });

        Scene scene = new Scene(petScreen, 640, 480);

        stage.setScene(scene);
    }


    // --------------------------
    // Game Screen
    // --------------------------

    private void showGameScreen() {

        GameScreen gameScreen = new GameScreen();

        Scene scene = new Scene(gameScreen, 640, 480);

        stage.setScene(scene);
    }


    public static void main(String[] args) {
        launch(args);
    }
}