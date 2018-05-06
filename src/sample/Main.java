package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.Scanner;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Dark.fxml"));
        primaryStage.setTitle("The Darkest Dungeon");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Dark.fxml"));
        primaryStage.setScene(new Scene(root, 640, 470));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) throws IOException {

        launch(args);

    }

    public static void Bain(String input) throws IOException {
        // TODO Auto-generated method stub
        Document doc = Jsoup.connect("https://darkestdungeon.gamepedia.com/"+input).get();
        Elements table = doc.getElementsByClass("wikitable charactertable");
        Elements row = table.select("tr");
        for (int x=0; x< 16; x++) {
            System.out.println(row.get(x).text());
        }
        Element skill1 = doc.getElementsByClass("wikitable").get(1);
        Element skill2 = doc.getElementsByClass("wikitable").get(3);
        Element skill3 = doc.getElementsByClass("wikitable").get(5);
        Element skill4 = doc.getElementsByClass("wikitable").get(7);
        Element skill5 = doc.getElementsByClass("wikitable").get(9);
        Element skill6 = doc.getElementsByClass("wikitable").get(11);
        Element skill7 = doc.getElementsByClass("wikitable").get(13);
        Elements indSkill = skill6.select("tr");
        for (int x=0; x< 9; x++) {
            if(x != 3) {
                System.out.println(indSkill.get(x).text());
            }

        }
    }
}
