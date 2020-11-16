package app;

import functions.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller1 implements Initializable {
    Image chickenImage = new Image("chicken.png");

    @FXML
    private ComboBox<String> sandwichTypeDropdown;

    @FXML
    private ImageView imageSandwich;

    @FXML
    private TextArea basicIngredientBox;

    @FXML
    private TextField sandwichPrice;

    @FXML
    private ListView<Extra> availableIngredients;

    @FXML
    private ListView<Extra> chosenIngredients;

    @FXML
    void addIngredient(ActionEvent event) {

    }

    @FXML
    void addToOrderPress(ActionEvent event) {

    }

    @FXML
    void clearIngredient(ActionEvent event) {

    }

    @FXML
    void openOrders(ActionEvent event) {

    }

    @FXML
    void pickSandwichType(ActionEvent event) {

    }

    @FXML
    void removeIngredient(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> sandwiches = FXCollections.observableArrayList("Chicken","Beef","Fish");
        sandwichTypeDropdown.setItems(sandwiches);
        sandwichTypeDropdown.getSelectionModel().select(0);
        imageSandwich.setImage(chickenImage);
        basicIngredientBox.appendText(new Chicken().getBasicIngredients());

        ObservableList<Extra> extraIngList = FXCollections.observableArrayList(
                new Extra("Lettuce"),new Extra("Tomatoes"),
                new Extra("Olives"),new Extra("Mozzarella"),
                new Extra("Blue Cheese"),new Extra("Chili"),
                new Extra("Potatoes"),new Extra("Fries"),
                new Extra("Avocado"),new Extra("Ketchup")
        );
        availableIngredients.setItems(extraIngList);

        sandwichPrice.appendText(Double.toString(new Chicken().price()));
    }
}
