package com.pocketpet.ui;

import javafx.scene.control.Button;

public class PixelButton extends Button {

    public PixelButton(String text) {
        super(text);

        setPrefWidth(100);
        setPrefHeight(40);
    }
}