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

/**
 *Secondary controller class for sandiwch order details
 *
 * @author Kaivalya Mishra, Ridwanur Sarder
 */
public class Controller2 implements Initializable {
    public Controller1 controller1 = new Controller1();

    @FXML
    private ListView<OrderLine> showOrder;

    @FXML
    private TextField orderPrice;

    @FXML
    private Button backButton;

    /**
     * Clears all the sandwiches in the order
     */
    @FXML
    void clearOrder() {

        for(OrderLine o:controller1.order.getOrderLines()) {
            System.out.println(o);
        }
        System.out.println(controller1.order.totalPrice() + " " + controller1.orderLines.size());

        controller1.orderLines.clear();
        controller1.order.clear();
    }

    /**
     * Closes order details window.
     */
    @FXML
    void closeWindow() {
        Stage stage = (Stage) backButton.getScene().getWindow();
        controller1.orderDetailsButton.setDisable(false);
        stage.close();
    }

    /**
     * Duplicates and adds an order line to the order
     */
    @FXML
    void duplicateOrder() {
        OrderLine selectedOrder = showOrder.getSelectionModel().getSelectedItem();
        if(selectedOrder != null) {
            OrderLine newOrder = new OrderLine(Order.getLineNumber() + 1,
                    selectedOrder.getSandwich(), selectedOrder.getSandwich().price());
            controller1.order.add(newOrder);
            controller1.orderLines.add(newOrder);
        }
    }

    /**
     * Exports order into a text file named Order.txt
     * @param event
     */
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

    /**
     * Removes an order line from the order
     */
    @FXML
    void removeOrder() {
        OrderLine selectedOrder = showOrder.getSelectionModel().getSelectedItem();
        controller1.order.remove(selectedOrder);
        controller1.orderLines.remove(selectedOrder);
    }

    /**
     * Sets a parent controller for this one to share data with.
     * @param controller1 to be set as parent controller
     */
    void setController1(Controller1 controller1){
        this.controller1 = controller1;
    }

    /**
     * Initializes sandwich order details window
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(OrderLine o:controller1.orderLines) {
            System.out.println(o);
        }
        System.out.println(controller1.order.totalPrice() + " " + controller1.orderLines.size());


        showOrder.setItems(controller1.orderLines);
        orderPrice.appendText("$" + controller1.order.totalPrice());
    }


}
