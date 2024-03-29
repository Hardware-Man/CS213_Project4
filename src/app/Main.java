package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *Driver and starter class for sandwich ordering GUI
 *
 * @author Kaivalya Mishra, Ridwanur Sarder
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("stage1.fxml"));
        primaryStage.setTitle("Sandwich Ordering");
        primaryStage.setScene(new Scene(root, 712, 460));
        primaryStage.show();
        Controller1.stage.setTitle("Order Details");
        primaryStage.setOnCloseRequest(windowEvent -> Controller1.stage.close());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
