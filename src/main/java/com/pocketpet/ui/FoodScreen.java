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
import javafx.scene.layout.GridPane;

import java.util.Random;

// This screen should be a menue where you can give the pet any food you want to give him/her.
// On the top there should be your pet, on the bottom the menue

public class FoodScreen extends StackPane {

    private GameController controller;

    private Pet pet;

     public FoodScreen(Pet pet) {
        
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
        // Menu for food
        // --------------------------
        
        GridPane foodMenu = new GridPane();

        foodMenu.setHgap(20);
        foodMenu.setVgap(20);

        foodMenu.setAlignment(Pos.CENTER);

        // Food Items

        ImageView apple = createFood("/images/food/apple.png");
        ImageView strawberry = createFood("/images/food/strawberry.png");
        ImageView chicken = createFood("/images/food/chicken.png");

        ImageView cake = createFood("/images/food/cake.png");
        ImageView carrot = createFood("/images/food/carrot.png");
        ImageView cookie = createFood("/images/food/cookie.png");
   
        // Adding Food items to the gridpane

        foodMenu.add(apple, 0, 0);
        foodMenu.add(strawberry, 1, 0);
        foodMenu.add(chicken, 2, 0);

        foodMenu.add(cake, 0, 1);
        foodMenu.add(carrot, 1, 1);
        foodMenu.add(cookie, 2, 1);


        // --------------------------
        // Game Pane
        // --------------------------

        AnchorPane game = new AnchorPane();

        game.getChildren().addAll(

                petImage,
                petName,
                foodMenu
        );


        // --------------------------
        // Root
        // --------------------------

        getChildren().addAll(frame, game);

        setAlignment(Pos.CENTER);
     }


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
}