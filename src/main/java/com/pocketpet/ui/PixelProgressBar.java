package com.pocketpet.ui;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;


public class PixelProgressBar extends StackPane {


    private final List<ImageView> blocks = new ArrayList<>();


    private final Image fillingImage = new Image(
            getClass()
                    .getResource("/images/progressbar-filling.png")
                    .toExternalForm()
    );


    private final int maxBlocks = 26;


    public PixelProgressBar() {


        HBox bar = new HBox();


        for (int i = 0; i < maxBlocks; i++) {


            ImageView block = new ImageView(fillingImage);

            block.setSmooth(false);

            blocks.add(block);

            bar.getChildren().add(block);
        }


        // Abstand vom Rahmen
        bar.setTranslateX(16);
        bar.setTranslateY(16);


        // Füllung
        getChildren().add(bar);


        // Rahmen darüber
        Image frameImage = new Image(
                getClass()
                        .getResource("/images/progressbar-frame.png")
                        .toExternalForm()
        );


        ImageView frame = new ImageView(frameImage);

        frame.setSmooth(false);


        getChildren().add(frame);


    }



    public void setValue(int percent) {


        int filledBlocks = Math.round(
                maxBlocks * percent / 100f
        );


        for (int i = 0; i < blocks.size(); i++) {

            blocks.get(i).setVisible(i < filledBlocks);

        }

    }

}