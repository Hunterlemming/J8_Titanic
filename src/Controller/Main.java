package Controller;

import Model.DataBase.DBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static DBC db;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../View/sample.fxml"));
        primaryStage.setTitle("Titanic");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        db = new DBC();

        launch(args);
    }

    public static DBC getDB(){
        return db;
    }
}
