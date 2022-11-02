package com.example._lab9;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class FigureApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FiguresMain figures = new FiguresMain();
        TableView<Circle> tableSquares = figures.createCirclesTable();
        TableView<Cylinder> tablePrisms = figures.createCylindersTable();
        stage.setTitle("Table of Circles and Cylinders");
        FlowPane root = new FlowPane(Orientation.VERTICAL, tableSquares, tablePrisms);
        Scene scene = new Scene(root, 700, 800);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}