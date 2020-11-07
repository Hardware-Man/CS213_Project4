package app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class Controller1 {

    @FXML
    private ComboBox<?> sandwichTypeDropdown;

    @FXML
    private ImageView image;

    @FXML
    private TextArea basicIngredientBox;

    @FXML
    private Button addSandwich;

    @FXML
    private Button openOrderDetails;

    @FXML
    private TextField sandwichPrice;

    @FXML
    private ListView<?> availableIngredients;

    @FXML
    private Button addIngredient;

    @FXML
    private Button removeIngredient;

    @FXML
    private ListView<?> chosenIngredients;

}
