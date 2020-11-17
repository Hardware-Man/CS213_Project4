package app;

import functions.Order;
import functions.OrderLine;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

/**
 * Secondary controller class for sandwich order details
 *
 * @author Kaivalya Mishra, Ridwanur Sarder
 */
public class Controller2 implements Initializable {
    DecimalFormat moneyFormat = new DecimalFormat("0.00");

    @FXML
    private ListView<OrderLine> showOrder;

    @FXML
    private TextField orderPrice;

    /**
     * Clears all the sandwiches in the order
     */
    @FXML
    void clearOrder() {
        Controller1.order.clear();
        showOrder.setItems(FXCollections.observableArrayList(Controller1.order.getOrderLines()));
        orderPrice.clear();
        orderPrice.appendText("$" + moneyFormat.format(Controller1.order.totalPrice()));
    }

    /**
     * Closes order details window.
     */
    @FXML
    void closeWindow() {
        Controller1.stage.close();
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
            Controller1.order.add(newOrder);
            showOrder.setItems(FXCollections.observableArrayList(Controller1.order.getOrderLines()));
            orderPrice.clear();
            orderPrice.appendText("$" + moneyFormat.format(Controller1.order.totalPrice()));
        }
    }

    /**
     * Exports order into a text file named Order.txt
     */
    @FXML
    void exportOrder() {
        File fileToExport = new File("Order.txt");
        try{
            PrintWriter output = new PrintWriter(fileToExport);
            for(OrderLine o:Controller1.order.getOrderLines()){
                output.write(o.toString() + "\n");
            }
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setContentText("File exported successfully.");
            a.show();
            output.close();
        }catch(FileNotFoundException ignored){}

    }

    /**
     * Removes an order line from the order
     */
    @FXML
    void removeOrder() {
        OrderLine selectedOrder = showOrder.getSelectionModel().getSelectedItem();
        Controller1.order.remove(selectedOrder);
        showOrder.setItems(FXCollections.observableArrayList(Controller1.order.getOrderLines()));
        orderPrice.clear();
        orderPrice.appendText("$" + moneyFormat.format(Controller1.order.totalPrice()));
    }

    /**
     * Initializes sandwich order details window
     * @param url Unused
     * @param resourceBundle Unused
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showOrder.setItems(FXCollections.observableArrayList(Controller1.order.getOrderLines()));
        orderPrice.appendText("$" + moneyFormat.format(Controller1.order.totalPrice()));
    }
}
