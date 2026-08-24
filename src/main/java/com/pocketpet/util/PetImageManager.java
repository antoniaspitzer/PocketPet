package com.pocketpet.util;

import com.pocketpet.model.PetColor;
import com.pocketpet.model.PetType;

import javafx.scene.image.Image;

public class PetImageManager {

    public static Image getPetImage(PetType type, PetColor color) {

        String path = "/images/pets/"
                + type.name().toLowerCase()
                + "/"
                + type.name().toLowerCase()
                + "-"
                + color.name().toLowerCase()
                + ".png";

        return new Image(
                PetImageManager.class
                        .getResource(path)
                        .toExternalForm()
        );
    }
}