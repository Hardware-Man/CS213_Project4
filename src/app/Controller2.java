package app;

import functions.Order;
import functions.OrderLine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {
    public Controller1 controller1 = new Controller1();
    ObservableList<OrderLine> orders = FXCollections.observableArrayList(controller1.order.getOrderLines());

    @FXML
    private ListView<OrderLine> showOrder;

    @FXML
    private TextField orderPrice;

    @FXML
    private Button backButton;

    @FXML
    void clearOrder() {
        orders.clear();
        controller1.order.clear();
    }

    @FXML
    void closeWindow(ActionEvent event) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void duplicateOrder() {
        OrderLine selectedOrder = showOrder.getSelectionModel().getSelectedItem();
        OrderLine newOrder = new OrderLine(Order.getLineNumber()+1,
                selectedOrder.getSandwich(),selectedOrder.getSandwich().price());
        controller1.order.add(newOrder);
        orders.add(newOrder);
    }

    @FXML
    void exportOrder(ActionEvent event) {
        File fileToExport = new File("Order.txt");
        try{
            PrintWriter output = new PrintWriter(fileToExport);
            for(OrderLine o:controller1.order.getOrderLines()){
                output.write(o.toString() + "\n");
            }
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setContentText("File exported successfully.");
            a.show();
        }catch(FileNotFoundException ignored){}

    }

    @FXML
    void removeOrder(ActionEvent event) {
        OrderLine selectedOrder = showOrder.getSelectionModel().getSelectedItem();
        controller1.order.remove(selectedOrder);
        orders.remove(selectedOrder);
    }

    void setController1(Controller1 controller1){
        this.controller1 = controller1;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showOrder.setItems(orders);
        orderPrice.appendText("$" + controller1.order.totalPrice());
    }


}
