package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.lang.invoke.MethodHandles;
import java.io.IOException;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Dark.fxml"));

        primaryStage.setTitle("The Darkest Dungeon");
        primaryStage.setScene(new Scene(root, 640, 470));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }

    public static void Window() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(MethodHandles.lookup().lookupClass().getResource("Generic.fxml"));
        stage.setTitle("The Darkest Hero");
        stage.setScene(new Scene(root, 730, 700));
        stage.setResizable(false);
        stage.show();
    }

    }


