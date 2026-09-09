package com.pocketpet;

import com.pocketpet.model.Pet;
import com.pocketpet.minigame.SnakeMiniGame;
import com.pocketpet.ui.ChoosePetScreen;
import com.pocketpet.ui.GameScreen;
import com.pocketpet.ui.StartScreen;
import com.pocketpet.minigame.FlappyPetGame;

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


    // ==========================================================
    // Start Screen
    // ==========================================================

    private void showStartScreen() {

        StartScreen startScreen = new StartScreen(() -> {

            showChoosePetScreen();

        });

        Scene scene = new Scene(
                startScreen,
                640,
                480
        );

        stage.setScene(scene);
    }


    // ==========================================================
    // Choose Pet Screen
    // ==========================================================

    private void showChoosePetScreen() {

        Pet pet = new Pet("Momo");

        ChoosePetScreen choosePetScreen =
                new ChoosePetScreen(
                        pet,

                        selectedPet -> {

                            showGameScreen(selectedPet);

                        }
                );

        Scene scene = new Scene(
                choosePetScreen,
                640,
                480
        );

        stage.setScene(scene);
    }


    // ==========================================================
    // Game Screen
    // ==========================================================

    private void showGameScreen(Pet pet) {

        GameScreen gameScreen =
                new GameScreen(
                        pet,

                        () -> {showSnakeMiniGame(pet);},
                        () -> {showFlappyBirdGame(pet);}
                );

        Scene scene = new Scene(
                gameScreen,
                640,
                480
        );

        stage.setScene(scene);
    }


    // ==========================================================
    // Snake Mini Game
    // ==========================================================

    private void showSnakeMiniGame(Pet pet) {

        SnakeMiniGame snakeMiniGame =
                new SnakeMiniGame(() -> {

                    pet.setHappiness(
                            Math.min(100, pet.getHappiness() + 15)
                    );

                    showGameScreen(pet);

                });

        Scene scene = new Scene(
                snakeMiniGame,
                640,
                480
        );

        stage.setScene(scene);

        // Wichtig für die Pfeiltasten!
        snakeMiniGame.requestFocus();
    }

    // ==========================================================
    // Flappy Bird Mini Game
    // ==========================================================

    private void showFlappyBirdGame(Pet pet) {

        FlappyPetGame flappyPetGame =
                new FlappyPetGame(() -> {

                    pet.setHappiness(
                            Math.min(100, pet.getHappiness() + 15)
                    );

                    showGameScreen(pet);

                });

        Scene scene = new Scene(
                flappyPetGame,
                640,
                480
        );

        stage.setScene(scene);

        // Wichtig für die Pfeiltasten!
        flappyPetGame.requestFocus();
    }


    // ==========================================================
    // Main
    // ==========================================================

    public static void main(String[] args) {

        launch(args);
    }
}