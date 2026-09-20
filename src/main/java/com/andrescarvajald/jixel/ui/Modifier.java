package com.andrescarvajald.jixel.ui;

import javafx.geometry.Pos;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

public class Modifier {
    private boolean fillMaxWidth = false;
    private boolean fillMaxHeight = false;
    private Pos alignment = null;
    private String backgroundColor = null;
    private String textFillColor = null;
    private String onHoverColor = null;

    private Modifier() {}

    public static Modifier create() {
        return new Modifier();
    }

    public Modifier fillMaxWidth() {
        this.fillMaxWidth = true;
        return this;
    }

    public Modifier fillMaxHeight() {
        this.fillMaxHeight = true;
        return this;
    }

    public Modifier fillMaxSize() {
        this.fillMaxWidth = true;
        this.fillMaxHeight = true;
        return this;
    }

    public Modifier align(Pos alignment) {
        this.alignment = alignment;
        return this;
    }


    public Modifier setFillColor(Color color) {
        this.textFillColor = getStringFromColor(color);
        return this;
    }

    public Modifier setBackgroundColor(Color color) {
        this.backgroundColor = getStringFromColor(color);
        return this;
    }

    public Modifier setOnHoverColor(Color color) {
        this.onHoverColor = getStringFromColor(color);
        return this;
    }

    public String getStringFromColor(Color color) {
        return String.format("#%02X%02X%02X",
                (int)(color.getRed() * 255),
                (int)(color.getGreen() * 255),
                (int)(color.getBlue() * 255));
    }

    public void apply(Region component) {
        if (fillMaxWidth) {
            component.setMaxWidth(Double.MAX_VALUE);
        }
        if (fillMaxHeight) {
            component.setMaxHeight(Double.MAX_VALUE);
        }
        StringBuilder css = new StringBuilder();

        if (alignment != null) {
            css.append("-fx-alignment: ").append(alignment.name().toLowerCase()).append(";");
        }
        if (backgroundColor != null) {
            css.append("-fx-background-color: ").append(backgroundColor).append(";");
        }
        if (textFillColor != null) {
            css.append("-fx-text-fill: ").append(textFillColor).append(";");
        }
        if (!css.isEmpty()) {
            if (onHoverColor != null) {
                applyOnHover(component);
            }
            component.setStyle(css.toString());
        }
    }

    private void applyOnHover(Region node) {
        node.setOnMouseEntered(e -> {
            node.setStyle(node.getStyle() + String.format("-fx-background-color: %s; -fx-cursor: hand;", this.onHoverColor));
        });
        node.setOnMouseExited(e -> {
            node.setStyle(node.getStyle().replaceAll("-fx-background-color:[^;]+;?", String.format("-fx-background-color: %s;", this.backgroundColor)));
        });
    }
}
