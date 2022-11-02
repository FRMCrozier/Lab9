package com.example._lab9;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class FigureApp2 extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view.fxml")));
        stage.setScene(new Scene(root));
        stage.setTitle("Cylinders Table");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}