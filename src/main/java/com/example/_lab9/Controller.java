package com.example._lab9;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;
import java.util.Objects;

public class Controller {
    FiguresMain figures = new FiguresMain();
    private ObservableList<Cylinder> list = figures.getCylinders();
    @FXML
    TextField filterField;
    @FXML
    private TableView<Cylinder> tableCylinders;
    @FXML
    private TableColumn<Cylinder, Double> height;
    @FXML
    private TableColumn<Cylinder, Double> radius;
    @FXML
    private TableColumn<Cylinder, Double> square;
    @FXML
    private TableColumn<Cylinder, Double> circumference;
    @FXML
    private TableColumn<Cylinder, Double> volume;


    @FXML
    public void initialize() {
        height.setCellValueFactory(new PropertyValueFactory<Cylinder, Double>("Height"));
        radius.setCellValueFactory(new PropertyValueFactory<Cylinder, Double>("Radius"));
        square.setCellValueFactory(new PropertyValueFactory<Cylinder, Double>("Square"));
        circumference.setCellValueFactory(new PropertyValueFactory<Cylinder, Double>("Circumference"));
        volume.setCellValueFactory(new PropertyValueFactory<Cylinder, Double>("Volume"));
        tableCylinders.setPrefWidth(400);
        tableCylinders.setPrefHeight(400);
        tableCylinders.setEditable(true);
        tableCylinders.setItems(list);

        FilteredList<Cylinder> filteredData = new FilteredList<>(list, p -> true);


        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(cylinder -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                if (String.valueOf(cylinder.getHeight()).contains(newValue)) {
                    return true;
                }
                else if (String.valueOf(cylinder.getRadius()).contains(newValue)) {
                    return true;
                }
                else if (String.valueOf(cylinder.getSquare()).contains(newValue)) {
                    return true;
                }
                else if (String.valueOf(cylinder.getCircumference()).contains(newValue)) {
                    return true;
                }
                else if (String.valueOf(cylinder.getVolume()).contains(newValue)) {
                    return true;
                }
                return false;
            });
        });

        SortedList<Cylinder> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableCylinders.comparatorProperty());
        tableCylinders.setItems(sortedData);


    }

}