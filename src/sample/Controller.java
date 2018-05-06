package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

import java.io.IOException;
import java.lang.invoke.MethodHandles;



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
        Darkest_imports.Bain("Abomination");

    }

    @FXML
    void AntiquarianClick(MouseEvent event) throws IOException {
        Darkest_imports.Bain("Antiquarian");

    }

    @FXML
    void ArbalestClick(MouseEvent event) throws IOException {
        Darkest_imports.Bain("Arbalest");
    }

    @FXML
    void BountyHunterClick(MouseEvent event) throws IOException {
        Darkest_imports.Bain("Bounty_Hunter");
        Main.Window();
        Controller2.HeroName.setText("Bounty Hunter");

    }

    @FXML
    void CrusaderClick(MouseEvent event) throws IOException {
        Darkest_imports.Bain("Crusader");
    }

    @FXML
    void DoctorClick(MouseEvent event) throws IOException {
        Darkest_imports.Bain("Plague_Doctor");
    }

    @FXML
    void FlagellantClick(MouseEvent event) throws IOException {
        Darkest_imports.Bain("Flagellant");
    }

    @FXML
    void GraveRobberClick(MouseEvent event) throws IOException {
        Darkest_imports.Bain("Grave_Robber");
    }

    @FXML
    void HellionClick(MouseEvent event) throws IOException {
        Darkest_imports.Bain("Hellion");
    }

    @FXML
    void HighwaymanClick(MouseEvent event) throws IOException {
        Darkest_imports.Bain("Highwayman");
    }

    @FXML
    void HoundmasterClick(MouseEvent event) throws IOException {
        Darkest_imports.Bain("Houndmaster");
    }

    @FXML
    void JesterClick(MouseEvent event) throws IOException {
        Darkest_imports.Bain("Jester");
    }

    @FXML
    void LeperClick(MouseEvent event) throws IOException {
        Darkest_imports.Bain("Leper");
    }

    @FXML
    void ManClick(MouseEvent event) throws IOException {
        Darkest_imports.Bain("Man-at-Arms");
    }

    @FXML
    void OccultistClick(MouseEvent event) throws IOException {
        Darkest_imports.Bain("Occultist");
    }

    @FXML
    void ShieldbreakerClick(MouseEvent event) throws IOException {
        Darkest_imports.Bain("Shieldbreaker");
    }

    @FXML
    void VestalClick(MouseEvent event) throws IOException {
        Darkest_imports.Bain("Vestal");
    }

}
