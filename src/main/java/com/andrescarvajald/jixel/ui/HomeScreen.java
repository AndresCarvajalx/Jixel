package com.andrescarvajald.jixel.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;

public class HomeScreen extends BorderPane {
    private final static StackPane stackPane = new StackPane();
    private final static VBox canvasSetupView = createCanvasSetupView();

    public HomeScreen() {
        super();
        stackPane.getChildren().addAll(canvasSetupView);
        this.setLeft(lateralPane());
        this.setCenter(stackPane);
        this.setBackground(new Background(new BackgroundFill(JixelTheme.BASE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    private VBox lateralPane() {
        VBox vbox = new VBox();
        vbox.setBackground(new Background(new BackgroundFill(JixelTheme.MANTLE, CornerRadii.EMPTY, Insets.EMPTY)));
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.setSpacing(10);
        vbox.setPrefWidth(150);
        JixelButton profileBtn = new JixelButton("Profile", JixelButton.getDefault()
                .setBackgroundColor(JixelTheme.SURFACE1)
                .setOnHoverColor(JixelTheme.SURFACE2)
                .align(Pos.CENTER)
                .fillMaxWidth(),
                _ -> System.out.println("Profile Clicked")
        );
        JixelButton createCanvasBtn = new JixelButton("New", JixelButton.getDefault()
                .align(Pos.CENTER)
                .setBackgroundColor(JixelTheme.BLUE)
                .setOnHoverColor(JixelTheme.SAPPHIRE)
                .fillMaxWidth(),
                _ -> canvasSetupView.toFront()
        );
        vbox.getChildren().addAll(profileBtn, createCanvasBtn);
        return vbox;
    }

    private static VBox createCanvasSetupView() {
        return new VBox();
    }
}
