package com.pocketpet.minigame;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

public class SnakeMiniGame extends StackPane {

    // --------------------------
    // Settings
    // --------------------------

    private static final int BOARD_SIZE = 480;
    private static final int TILE_SIZE = 24;

    private static final int MAX_SCORE = 5;

    // --------------------------
    // Snake
    // --------------------------

    private class Tile {

        int x;
        int y;

        Tile(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private Tile snakeHead;
    private ArrayList<Tile> snakeBody;

    // --------------------------
    // Food
    // --------------------------

    private Tile food;
    private Random random;

    // --------------------------
    // Game Logic
    // --------------------------

    private int velocityX;
    private int velocityY;

    private int score = 0;

    private Timeline gameLoop;

    private boolean gameOver = false;

    // --------------------------
    // UI
    // --------------------------

    private Pane gameBoard;
    private Label scoreLabel;

    // Wird ausgeführt, wenn das Minigame fertig ist
    private Runnable onGameFinished;


    // ==========================================================
    // Constructor
    // ==========================================================

    public SnakeMiniGame(Runnable onGameFinished) {

        this.onGameFinished = onGameFinished;

        setPrefSize(BOARD_SIZE, BOARD_SIZE);

        // --------------------------
        // Game Board
        // --------------------------

        gameBoard = new Pane();

        gameBoard.setPrefSize(
                BOARD_SIZE,
                BOARD_SIZE
        );

        gameBoard.setStyle(
                "-fx-background-color: black;"
        );


        // --------------------------
        // Score
        // --------------------------

        scoreLabel = new Label("0 / " + MAX_SCORE);

        scoreLabel.setStyle("""
                -fx-text-fill: white;
                -fx-font-size: 20px;
                -fx-font-weight: bold;
                """);

        StackPane.setAlignment(
                scoreLabel,
                Pos.TOP_CENTER
        );


        // --------------------------
        // Add UI
        // --------------------------

        getChildren().addAll(
                gameBoard,
                scoreLabel
        );


        // --------------------------
        // Start Game
        // --------------------------

        initializeGame();

        setupKeyboard();

        startGameLoop();

        requestFocus();
    }


    // ==========================================================
    // Initialize Game
    // ==========================================================

    private void initializeGame() {

        snakeHead = new Tile(
                10,
                10
        );

        snakeBody = new ArrayList<>();

        food = new Tile(
                5,
                5
        );

        random = new Random();

        velocityX = 0;
        velocityY = 0;

        score = 0;

        gameOver = false;

        placeFood();

        updateScore();

        draw();
    }


    // ==========================================================
    // Game Loop
    // ==========================================================

    private void startGameLoop() {

        gameLoop = new Timeline(
                new KeyFrame(
                        Duration.millis(100),
                        event -> {

                            move();

                            draw();

                        }
                )
        );

        gameLoop.setCycleCount(
                Timeline.INDEFINITE
        );

        gameLoop.play();
    }


    // ==========================================================
    // Keyboard
    // ==========================================================

    private void setupKeyboard() {

        setOnKeyPressed(event -> {

            KeyCode key = event.getCode();


            if (key == KeyCode.UP && velocityY != 1) {

                velocityX = 0;
                velocityY = -1;

            }

            else if (key == KeyCode.DOWN && velocityY != -1) {

                velocityX = 0;
                velocityY = 1;

            }

            else if (key == KeyCode.LEFT && velocityX != 1) {

                velocityX = -1;
                velocityY = 0;

            }

            else if (key == KeyCode.RIGHT && velocityX != -1) {

                velocityX = 1;
                velocityY = 0;

            }
        });
    }


    // ==========================================================
    // Move Snake
    // ==========================================================

    private void move() {

        if (gameOver) {
            return;
        }


        // --------------------------
        // Eat Food
        // --------------------------

        if (collision(snakeHead, food)) {

            snakeBody.add(
                    new Tile(
                            food.x,
                            food.y
                    )
            );

            score++;

            updateScore();


            // 5 Bälle erreicht
            if (score >= MAX_SCORE) {

                finishGame();

                return;
            }


            placeFood();
        }


        // --------------------------
        // Move Body
        // --------------------------

        for (int i = snakeBody.size() - 1; i >= 0; i--) {

            Tile snakePart = snakeBody.get(i);

            if (i == 0) {

                snakePart.x = snakeHead.x;
                snakePart.y = snakeHead.y;

            } else {

                Tile previousPart =
                        snakeBody.get(i - 1);

                snakePart.x = previousPart.x;
                snakePart.y = previousPart.y;
            }
        }


        // --------------------------
        // Move Head
        // --------------------------

        snakeHead.x += velocityX;
        snakeHead.y += velocityY;


        // --------------------------
        // Collision with Body
        // --------------------------

        for (Tile snakePart : snakeBody) {

            if (collision(
                    snakeHead,
                    snakePart
            )) {

                gameOver = true;

                stopGame();
                return;
            }
        }


        // --------------------------
        // Collision with Wall
        // --------------------------

        if (
                snakeHead.x < 0 ||
                snakeHead.x >= BOARD_SIZE / TILE_SIZE ||
                snakeHead.y < 0 ||
                snakeHead.y >= BOARD_SIZE / TILE_SIZE
        ) {

            gameOver = true;

            stopGame();
        }
    }


    // ==========================================================
    // Place Food
    // ==========================================================

    private void placeFood() {

        do {

            food.x = random.nextInt(
                    BOARD_SIZE / TILE_SIZE
            );

            food.y = random.nextInt(
                    BOARD_SIZE / TILE_SIZE
            );

        } while (isSnakePosition(food));
    }


    // ==========================================================
    // Check if Food is inside Snake
    // ==========================================================

    private boolean isSnakePosition(Tile tile) {

        if (collision(snakeHead, tile)) {
            return true;
        }

        for (Tile part : snakeBody) {

            if (collision(part, tile)) {
                return true;
            }
        }

        return false;
    }


    // ==========================================================
    // Collision
    // ==========================================================

    private boolean collision(
            Tile tile1,
            Tile tile2
    ) {

        return tile1.x == tile2.x &&
                tile1.y == tile2.y;
    }


    // ==========================================================
    // Draw
    // ==========================================================

    private void draw() {

        gameBoard.getChildren().clear();


        // --------------------------
        // Food
        // --------------------------

        Rectangle foodRect = new Rectangle(
                TILE_SIZE,
                TILE_SIZE
        );

        foodRect.setFill(Color.RED);

        foodRect.setX(
                food.x * TILE_SIZE
        );

        foodRect.setY(
                food.y * TILE_SIZE
        );


        // --------------------------
        // Snake Head
        // --------------------------

        Rectangle headRect = new Rectangle(
                TILE_SIZE,
                TILE_SIZE
        );

        headRect.setFill(Color.LIMEGREEN);

        headRect.setX(
                snakeHead.x * TILE_SIZE
        );

        headRect.setY(
                snakeHead.y * TILE_SIZE
        );


        gameBoard.getChildren().addAll(
                foodRect,
                headRect
        );


        // --------------------------
        // Snake Body
        // --------------------------

        for (Tile snakePart : snakeBody) {

            Rectangle bodyRect = new Rectangle(
                    TILE_SIZE,
                    TILE_SIZE
            );

            bodyRect.setFill(
                    Color.GREEN
            );

            bodyRect.setX(
                    snakePart.x * TILE_SIZE
            );

            bodyRect.setY(
                    snakePart.y * TILE_SIZE
            );

            gameBoard.getChildren().add(
                    bodyRect
            );
        }
    }


    // ==========================================================
    // Update Score
    // ==========================================================

    private void updateScore() {

        scoreLabel.setText(
                score + " / " + MAX_SCORE
        );
    }


    // ==========================================================
    // Finish Game
    // ==========================================================

    private void finishGame() {

        stopGame();

        if (onGameFinished != null) {

            onGameFinished.run();
        }
    }


    // ==========================================================
    // Stop Game
    // ==========================================================

    private void stopGame() {

        if (gameLoop != null) {

            gameLoop.stop();
        }
    }
}