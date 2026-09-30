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


// This screen should be a menu where you can give the pet any food you want to give him/her.
// On the top there should be your pet, on the bottom the menu

public class FoodScreen extends StackPane {

    private GameController controller;
    private Pet pet;
    private Runnable onFoodSelected;


    public FoodScreen(Pet pet, Runnable onFoodSelected) {

        this.pet = pet;
        this.onFoodSelected = onFoodSelected;

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
        // Message
        // --------------------------

        Label messageLabel = new Label();

        messageLabel.setLayoutX(100);
        messageLabel.setLayoutY(340);

        messageLabel.setStyle("""
                -fx-font-size: 16;
                """);

        messageLabel.setWrapText(true);
        messageLabel.setPrefWidth(440);

        // --------------------------
        // Menu for food
        // --------------------------

        GridPane foodMenu = new GridPane();

        foodMenu.setHgap(20);
        foodMenu.setVgap(20);

        foodMenu.setAlignment(Pos.CENTER);

        foodMenu.setLayoutX(190);
        foodMenu.setLayoutY(220);

        // --------------------------
        // Food Items
        // --------------------------

        ImageView apple = createFood("/images/food/apple.png");
        ImageView strawberry = createFood("/images/food/strawberry.png");
        ImageView chicken = createFood("/images/food/chicken.png");

        ImageView cake = createFood("/images/food/cake.png");
        ImageView carrot = createFood("/images/food/carrot.png");
        ImageView cookie = createFood("/images/food/cookie.png");

        // --------------------------
        // Adding Food items
        // --------------------------

        foodMenu.add(apple, 0, 0);
        foodMenu.add(strawberry, 1, 0);
        foodMenu.add(chicken, 2, 0);

        foodMenu.add(cake, 0, 1);
        foodMenu.add(carrot, 1, 1);
        foodMenu.add(cookie, 2, 1);

        // --------------------------
        // Click events
        // --------------------------

        apple.setOnMouseClicked(event -> {
            System.out.println(pet.getName() + " ate the apple!");
            onFoodSelected.run();
        });

        strawberry.setOnMouseClicked(event -> {
            System.out.println(pet.getName() + " ate the strawberry!");
            onFoodSelected.run();
        });

        chicken.setOnMouseClicked(event -> {
            System.out.println(pet.getName() + " ate the chicken!");
            onFoodSelected.run();
        });

        cake.setOnMouseClicked(event -> {
            System.out.println(pet.getName() + " ate the cake!");
            onFoodSelected.run();
        });

        carrot.setOnMouseClicked(event -> {
            System.out.println(pet.getName() + " ate the carrot!");
            onFoodSelected.run();
        });

        cookie.setOnMouseClicked(event -> {
            System.out.println(pet.getName() + " ate the cookie!");
            onFoodSelected.run();
        });


        // --------------------------
        // Game Pane
        // --------------------------

        AnchorPane game = new AnchorPane();

        game.getChildren().addAll(
                petImage,
                petName,
                messageLabel,
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