package com.example._lab9;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.Random;

public class FiguresMain {

    Random random = new Random();

    public ObservableList<Circle> getCircles() {

        int number = 10;
        ArrayList<Circle> circles = new ArrayList<>();
        for (int i = 0; i <= number; i++) {
            circles.add(new Circle(random.nextDouble(1,70)));
        }
        ObservableList<Circle> list = FXCollections.observableArrayList(circles);
        return list;
    }

    public ObservableList<Cylinder> getCylinders() {

        int number = 10;
        ArrayList<Cylinder> cylinders = new ArrayList<>();
        for (int i = 0; i <= number; i++) {
            cylinders.add(new Cylinder(random.nextDouble(1,70), random.nextDouble(10,70)));
        }
        ObservableList<Cylinder> list = FXCollections.observableArrayList(cylinders);
        return list;

    }

    public TableView createCirclesTable() {
        TableView<Circle> tableCircles = new TableView<Circle>();
        TableColumn<Circle, Double> radiusCol //
                = new TableColumn<Circle, Double>("Radius");
        TableColumn<Circle, Double> squareCol//
                = new TableColumn<Circle, Double>("Square");
        TableColumn<Circle, Double> circumferenceCol//
                = new TableColumn<Circle, Double>("Circumference");
        radiusCol.setCellValueFactory(new PropertyValueFactory<>("Radius"));
        squareCol.setCellValueFactory(new PropertyValueFactory<>("Square"));
        circumferenceCol.setCellValueFactory(new PropertyValueFactory<>("Circumference"));
        ObservableList<Circle> listCirc = getCircles();
        tableCircles.setPrefWidth(400);
        tableCircles.setPrefHeight(400);
        tableCircles.setItems(listCirc);
        tableCircles.getColumns().addAll(radiusCol, squareCol, circumferenceCol);
        return tableCircles;
    }


    public TableView createCylindersTable() {
        TableView<Cylinder> tableCylinders = new TableView<Cylinder>();
        TableColumn<Cylinder, Double> heightCol //
                = new TableColumn<Cylinder, Double>("Height");

        TableColumn<Cylinder, Double> circleCol //
                = new TableColumn<Cylinder, Double>("Circle Info");
        TableColumn<Cylinder, Double> radiusCol //
                = new TableColumn<Cylinder, Double>("Radius");
        TableColumn<Cylinder, Double> squareCol//
                = new TableColumn<Cylinder, Double>("Square");
        TableColumn<Cylinder, Double> circumferenceCol//
                = new TableColumn<Cylinder, Double>("Circumference");
        circleCol.getColumns().addAll(radiusCol, squareCol, circumferenceCol);

        TableColumn<Cylinder, Double> volumeCol//
                = new TableColumn<Cylinder, Double>("Volume");
        heightCol.setCellValueFactory(new PropertyValueFactory<>("Height"));
        radiusCol.setCellValueFactory(new PropertyValueFactory<>("Radius"));
        squareCol.setCellValueFactory(new PropertyValueFactory<>("Square"));
        circumferenceCol.setCellValueFactory(new PropertyValueFactory<>("Circumference"));
        volumeCol.setCellValueFactory(new PropertyValueFactory<>("Volume"));
        ObservableList<Cylinder> listCyl = getCylinders();
        tableCylinders.setPrefWidth(650);
        tableCylinders.setPrefHeight(400);
        tableCylinders.setItems(listCyl);
        tableCylinders.getColumns().addAll(heightCol, circleCol, volumeCol);
        return tableCylinders;
    }


}