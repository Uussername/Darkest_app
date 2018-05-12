package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.lang.invoke.MethodHandles;
import java.io.IOException;

/**
 * Main class for running each window
 * contains the main window and secondary window of Dark.fxml and Generic.fxml
 */
public class Main extends Application {

    /**
     * Primary window setup, loads the resource Dark.fxml
     * and sets its controller to Controller programmatically
     * @param primaryStage
     * @throws Exception
     *
     * loads Dark.fxml
     * Sets controller of Dark.fxml to Controller.java
     * sets stage size, title, and prevents resizing
     *
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dark.fxml"));
        fxmlLoader.setController(new Controller());
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("The Darkest Statistics");
        primaryStage.setScene(new Scene(root, 640, 470));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }

    /**
     * Similar to main window but passes some additional values to Controller2 from Controller
     * @param name Title of window also used to run SetValues in Controller2
     * @param hero Object containing table elements
     * @throws IOException due to the use of Jsoup objects
     *
     * loads Generic.fxml
     * Sets controller of Generic.fxml to Controller2.java
     *
     * creates in instance of Controller2 so that the SetValues method can be used
     *
     * sets stage size, title, and prevents resizing
     *
     * @return the stage created
     */
    public static Stage Window(String name, Heroes hero) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MethodHandles.lookup().lookupClass().getResource("Generic.fxml"));
        fxmlLoader.setController(new Controller2());
        Parent root = fxmlLoader.load();

        Controller2 cont = fxmlLoader.getController();
        cont.SetValues(hero, name);

        Stage stage = new Stage();
        stage.setTitle(name);
        stage.setScene(new Scene(root, 730, 750));
        stage.setResizable(false);
        stage.show();
        return stage;
    }
}


