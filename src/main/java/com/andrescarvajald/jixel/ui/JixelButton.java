package com.andrescarvajald.jixel.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class JixelButton extends Button {
    public JixelButton(String title, Modifier modifier, EventHandler<ActionEvent> handler) {
        super();
        this.setText(title);
        this.setOnAction(handler);
        if (modifier != null) {
            modifier.apply(this);
        }
    }
}
