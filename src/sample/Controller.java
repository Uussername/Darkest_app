package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;


public class Controller {

    @FXML
    public VBox window;

    @FXML
    public AnchorPane Anchorpane;

    @FXML
    public Rectangle background;

    @FXML
    public ImageView Logo;

    @FXML
    public ImageView imageBountyHunter;

    @FXML
    public ImageView imageAbomination;

    @FXML
    public ImageView imagePlagueDoctor;

    @FXML
    public ImageView imageGraveRobber;

    @FXML
    public ImageView imageLeper;

    @FXML
    public ImageView imageOccultist;

    @FXML
    public ImageView imageShieldbreaker;

    @FXML
    public ImageView imageAntiquarian;

    @FXML
    public ImageView imageHoundmaster;

    @FXML
    public ImageView imageArbalest;

    @FXML
    public ImageView imageCrusader;

    @FXML
    public ImageView imageManAtArms;

    @FXML
    public ImageView imageJester;

    @FXML
    public ImageView imageHellion;

    @FXML
    public ImageView imageHighwayman;

    @FXML
    public ImageView imageVestal;

    @FXML
    public ImageView imageFlagellant;

    @FXML
    public Label labelAbomination;

    @FXML
    public Label labelAntiquarian;

    @FXML
    public Label labelArbalest;

    @FXML
    public Label labelBountyHunter;

    @FXML
    public Label labelCrusader;

    @FXML
    public Label labelFlagellant;

    @FXML
    public Label labelGraveRobber;

    @FXML
    public Label labelHellion;

    @FXML
    public Label labelHighwayman;

    @FXML
    public Label labelHoundmaster;

    @FXML
    public Label labelJester;

    @FXML
    public Label labelLeper;

    @FXML
    public Label labelManAtArms;

    @FXML
    public Label labelOccultist;

    @FXML
    public Label labelPlagueDoctor;

    @FXML
    public Label labelShieldbreaker;

    @FXML
    public Label labelVestal;


    @FXML
    void AbominationClick(MouseEvent event) throws IOException {
        Heroes Abomination = new Heroes("Abomination");
        Field[] fields = Heroes.class.getFields();

    }

    @FXML
    void AntiquarianClick(MouseEvent event) throws IOException {
        Heroes Antiquarian = new Heroes("Antiquarian");

    }

    @FXML
    void ArbalestClick(MouseEvent event) throws IOException {
        Heroes Arbalest = new Heroes("Arbalest");
    }

    @FXML
    void BountyHunterClick(MouseEvent event) throws IOException {

        Heroes BountyHunter = new Heroes("Bounty_Hunter");
        Main.Window("Bounty Hunter");

    }

    @FXML
    void CrusaderClick(MouseEvent event) throws IOException {
        Heroes Crusader = new Heroes("Crusader");
    }

    @FXML
    void DoctorClick(MouseEvent event) throws IOException {
        Heroes PlagueDoctor = new Heroes("Plague_Doctor");

    }

    @FXML
    void FlagellantClick(MouseEvent event) throws IOException {
        Heroes Flagellant = new Heroes("Flagellant");
        Main.Window("Flagellant");
    }

    @FXML
    void GraveRobberClick(MouseEvent event) throws IOException {
        Heroes GraveRobber = new Heroes("Grave_Robber");
    }

    @FXML
    void HellionClick(MouseEvent event) throws IOException {
        Heroes Hellion = new Heroes("Hellion");
    }

    @FXML
    void HighwaymanClick(MouseEvent event) throws IOException {
        Heroes Highwayman = new Heroes("Highwayman");
    }

    @FXML
    void HoundmasterClick(MouseEvent event) throws IOException {
        Heroes Houndmaster = new Heroes("Houndmaster");
    }

    @FXML
    void JesterClick(MouseEvent event) throws IOException {
        Heroes Jester = new Heroes("Jester");
    }

    @FXML
    void LeperClick(MouseEvent event) throws IOException {
        Heroes Leper = new Heroes("Leper");
    }

    @FXML
    void ManClick(MouseEvent event) throws IOException {
        Heroes ManAtArms = new Heroes("Man-at-Arms");
    }

    @FXML
    void OccultistClick(MouseEvent event) throws IOException {
        Heroes Occultist = new Heroes("Occultist");
    }

    @FXML
    void ShieldbreakerClick(MouseEvent event) throws IOException {
        Heroes Sheildbreaker = new Heroes("Shieldbreaker");
    }

    @FXML
    void VestalClick(MouseEvent event) throws IOException {
        Heroes Vestal = new Heroes("Vestal");
    }

}
