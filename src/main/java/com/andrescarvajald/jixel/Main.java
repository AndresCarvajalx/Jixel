package com.andrescarvajald.jixel;

import com.andrescarvajald.jixel.ui.HomeScreen;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.controlsfx.tools.Borders;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.setTitle("Jixel");
        HomeScreen homeScreen = new HomeScreen();
        stage.setScene(new Scene(homeScreen));
        stage.show();
    }
}