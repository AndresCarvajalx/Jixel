package com.andrescarvajald.jixel.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import org.kordamp.ikonli.javafx.Icon;

public class JixelButton extends Button {
    public JixelButton(String title, Modifier modifier, EventHandler<ActionEvent> handler) {
        super(title);
        this.setOnAction(handler);
        if (modifier != null) {
            modifier.apply(this);
        }
    }

    public JixelButton(String title) {
        this.setText(title);
        getDefault().apply(this);
    }

    public JixelButton(Icon icon, Modifier modifier, EventHandler<ActionEvent> handler) {
        getDefault().apply(this);
    }

    public static Modifier getDefault() {
        return Modifier.create().setFillColor(Color.WHITE)
                .setBackgroundColor(Color.rgb(49, 50, 68))
                .setOnHoverColor(Color.rgb(88, 91, 112));
    }
}
