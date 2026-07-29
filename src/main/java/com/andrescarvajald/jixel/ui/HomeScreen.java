package com.andrescarvajald.jixel.ui;

import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class HomeScreen extends BorderPane {
    public HomeScreen() {
        super();
        this.setLeft(lateralPane());
    }

    private VBox lateralPane() {
        VBox vbox = new VBox();
        vbox.setPrefWidth(150);
        JixelButton button = new JixelButton("Create Canvas", Modifier.create()
                .fillMaxSize()
                .align(Pos.CENTER)
                .fillMaxWidth()
                .setFillColor(Color.WHITE)
                .setBackgroundColor(Color.rgb(112, 128, 144)),
                _ -> System.out.println("Home button clicked")
        );
        vbox.getChildren().add(button);
        return vbox;
    }
}
