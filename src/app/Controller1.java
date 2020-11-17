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

    private final Image chickenImage = new Image("chicken.png");

    private final Image fishImage = new Image("fish.png");

    private final Image beefImage = new Image("beef.png");

    private final ObservableList<String> sandwiches = FXCollections.observableArrayList("Chicken","Beef","Fish");

    private final ObservableList<Extra> extraIngList = FXCollections.observableArrayList(
            new Extra("Lettuce"),new Extra("Tomatoes"),
            new Extra("Olives"),new Extra("Mozzarella"),
            new Extra("Blue Cheese"),new Extra("Chili"),
            new Extra("Potatoes"),new Extra("Fries"),
            new Extra("Avocado"),new Extra("Ketchup")
    );

    private final ObservableList<Extra> chosenIngList = FXCollections.observableArrayList();

    private Sandwich sandwich;

    static Order order = new Order();

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

    static final Stage stage = new Stage();


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
     * @throws IOException Checks for IOException
     */
    @FXML
    void addToOrderPress() throws IOException {
        OrderLine orderline = new OrderLine(Order.lineNumber + 1,sandwich,sandwich.price());
        order.add(orderline);
        pickSandwichType();
        if (stage.isShowing()) openOrders();
    }

    /**
     * Opens order details window
     * @throws IOException Checks for IOException
     */
    @FXML
    void openOrders() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("stage2.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
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
                basicIngredientBox.appendText(sandwich.getBasicIngredients());
            }
            case "Beef" -> {
                sandwich = new Beef();
                basicIngredientBox.clear();
                imageSandwich.setImage(beefImage);
                basicIngredientBox.appendText(sandwich.getBasicIngredients());
            }
            case "Fish" -> {
                sandwich = new Fish();
                basicIngredientBox.clear();
                imageSandwich.setImage(fishImage);
                basicIngredientBox.appendText(sandwich.getBasicIngredients());
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
        basicIngredientBox.appendText(new Chicken().getBasicIngredients());

        availableIngredients.setItems(extraIngList);
        chosenIngredients.setItems(chosenIngList);
        availableIngredients.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        chosenIngredients.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        sandwichPrice.appendText("$" + new Chicken().price());
    }
}
