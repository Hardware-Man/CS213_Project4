package app;

import functions.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *Primary controller class for sandwich ordering GUI
 *
 * @author Kaivalya Mishra, Ridwanur Sarder
 */
public class Controller1 implements Initializable {
    @FXML
    private final Image chickenImage = new Image("chicken.png");

    @FXML
    private final Image fishImage = new Image("fish.png");

    @FXML
    private final Image beefImage = new Image("beef.png");

    @FXML
    private final ObservableList<String> sandwiches = FXCollections.observableArrayList("Chicken","Beef","Fish");

    @FXML
    private final ObservableList<Extra> extraIngList = FXCollections.observableArrayList(
            new Extra("Lettuce"),new Extra("Tomatoes"),
            new Extra("Olives"),new Extra("Mozzarella"),
            new Extra("Blue Cheese"),new Extra("Chili"),
            new Extra("Potatoes"),new Extra("Fries"),
            new Extra("Avocado"),new Extra("Ketchup")
    );

    @FXML
    private final ObservableList<Extra> chosenIngList = FXCollections.observableArrayList();

    @FXML
    private Sandwich sandwich;

    @FXML
    static Order order = new Order();

    @FXML
    static ObservableList<OrderLine> orderLines = FXCollections.observableArrayList(order.getOrderLines());

    @FXML
    private Button orderDetailsButton;

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
    private Button addToOrderButton;


    /**
     * Adds an ingredient to the menu of what ingredients the client wants in burger.
     */
    @FXML
    void addIngredient() {
        ObservableList<Extra> pickedIngredients = availableIngredients.getSelectionModel().getSelectedItems();
        if(sandwich.checkForSpace(pickedIngredients)){
            sandwich.addAll(pickedIngredients);
            chosenIngList.addAll(pickedIngredients);
            extraIngList.removeAll(pickedIngredients);
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Can only have 6 extra ingredients!");
            a.show();
        }
        sandwichPrice.clear();
        sandwichPrice.appendText("$" + sandwich.price());
    }

    /**
     * Removes an ingredient from menu of what ingredients the client wants in burger
     */
    @FXML
    void removeIngredient() {
        ObservableList<Extra> pickedIngredients = chosenIngredients.getSelectionModel().getSelectedItems();
        extraIngList.addAll(pickedIngredients);
        sandwich.removeAll(pickedIngredients);
        chosenIngList.removeAll(pickedIngredients);
        sandwichPrice.clear();
        sandwichPrice.appendText("$" + sandwich.price());
    }

    /**
     * Clears all ingredients from menu of what ingredient client wants in burger
     */
    @FXML
    void clearIngredient() {
        extraIngList.addAll(chosenIngList);
        chosenIngList.clear();
        sandwich.clear();
        sandwichPrice.clear();
        sandwichPrice.appendText("$" + sandwich.price());
    }

    /**
     * Adds an order line to order for current sandwich
     */
    @FXML
    void addToOrderPress() {
        OrderLine orderline = new OrderLine(Order.getLineNumber() + 1,sandwich,sandwich.price());
        order.add(orderline);
        pickSandwichType();
        orderLines = FXCollections.observableArrayList(order.getOrderLines());
    }

    /**
     * Opens order details window
     * @throws IOException a
     */
    @FXML
    void openOrders() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("stage2.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Order Details");
        stage.setScene(new Scene(root));
        orderDetailsButton.setDisable(true);
        addToOrderButton.setDisable(true);
        stage.setOnCloseRequest(windowEvent -> {
            orderDetailsButton.setDisable(false);
            addToOrderButton.setDisable(false);
        });
        stage.show();
    }

    /**
     * Picks a type of sandwich based on user choice
     */
    @FXML
    void pickSandwichType() {
        switch(sandwichTypeDropdown.getSelectionModel().getSelectedItem()) {
            case "Chicken" -> {
                sandwich = new Chicken();
                basicIngredientBox.clear();
                imageSandwich.setImage(chickenImage);
                basicIngredientBox.appendText(sandwich.getBasicIngredients(((Chicken) sandwich).ingredients));
            }
            case "Beef" -> {
                sandwich = new Beef();
                basicIngredientBox.clear();
                imageSandwich.setImage(beefImage);
                basicIngredientBox.appendText(sandwich.getBasicIngredients(((Beef) sandwich).ingredients));
            }
            case "Fish" -> {
                sandwich = new Fish();
                basicIngredientBox.clear();
                basicIngredientBox.appendText(sandwich.getBasicIngredients(((Fish) sandwich).ingredients));
                imageSandwich.setImage(fishImage);
            }
        }
        sandwich.addAll(chosenIngList);
        sandwichPrice.clear();
        sandwichPrice.appendText("$" + sandwich.price());
    }

    /**
     * Initializes the sandwich ordering primary GUI
     * @param url Unused
     * @param resourceBundle Unused
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sandwich = new Chicken();
        sandwichTypeDropdown.setItems(sandwiches);
        sandwichTypeDropdown.getSelectionModel().select(0);

        imageSandwich.setImage(chickenImage);
        basicIngredientBox.appendText(new Chicken().getBasicIngredients(new Chicken().ingredients));

        availableIngredients.setItems(extraIngList);
        chosenIngredients.setItems(chosenIngList);
        availableIngredients.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        chosenIngredients.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        sandwichPrice.appendText("$" + new Chicken().price());
    }
}
