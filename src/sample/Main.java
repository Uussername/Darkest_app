package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.*;
import javafx.stage.Stage;
import java.lang.invoke.MethodHandles;
import java.io.IOException;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dark.fxml"));
        fxmlLoader.setController(new Controller());
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("The Darkest Dungeon");
        primaryStage.setScene(new Scene(root, 640, 470));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }

    public static Stage Window(String name, Heroes hero) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MethodHandles.lookup().lookupClass().getResource("Generic.fxml"));
        fxmlLoader.setController(new Controller2());
        Parent root = fxmlLoader.load();

        Controller2 cont = fxmlLoader.getController();
        cont.SetValues(hero, name);
        //cont.SetTable(hero, 1);

        Stage stage = new Stage();
        stage.setTitle(name);
        stage.setScene(new Scene(root, 730, 630));
        stage.setResizable(false);
        stage.show();
        return stage;
    }
}


