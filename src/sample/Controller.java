package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for Dark.fxml mainly sets values for Controller2 based on which image was clicked
 *
 */
public class Controller implements Initializable{

    /**
     * all methods are effectively identical
     * When an image is clicked, will create a new Heros object and a new window tailored to the hero
     * @param event
     * @throws IOException
     *
     * Create new object
     * run the new window command using the URL end tag and the Heroes object created
     */
    @FXML
    void AbominationClick(MouseEvent event) throws IOException {
        Heroes Abomination = new Heroes("Abomination");
        Main.Window("Abomination", Abomination);

    }

    @FXML
    void AntiquarianClick(MouseEvent event) throws IOException {
        Heroes Antiquarian = new Heroes("Antiquarian");
        Main.Window("Antiquarian", Antiquarian);
    }

    @FXML
    void ArbalestClick(MouseEvent event) throws IOException {
        Heroes Arbalest = new Heroes("Arbalest");
        Main.Window("Arbalest", Arbalest);
    }

    @FXML
    void BountyHunterClick(MouseEvent event) throws IOException {
        Heroes BountyHunter = new Heroes("Bounty_Hunter");
        Main.Window("Bounty_Hunter", BountyHunter);

    }

    @FXML
    void CrusaderClick(MouseEvent event) throws IOException {
        Heroes Crusader = new Heroes("Crusader");
        //Heroes.test(Crusader);
        Main.Window("Crusader", Crusader);
    }

    @FXML
    void DoctorClick(MouseEvent event) throws IOException {
        Heroes PlagueDoctor = new Heroes("Plague_Doctor");
        Main.Window("Plague_Doctor", PlagueDoctor);
    }

    @FXML
    void FlagellantClick(MouseEvent event) throws IOException {
        Heroes Flagellant = new Heroes("Flagellant");
        Main.Window("Flagellant", Flagellant);
    }

    @FXML
    void GraveRobberClick(MouseEvent event) throws IOException {
        Heroes GraveRobber = new Heroes("Grave_Robber");
        Main.Window("Grave_Robber", GraveRobber);
    }

    @FXML
    void HellionClick(MouseEvent event) throws IOException {
        Heroes Hellion = new Heroes("Hellion");
        Main.Window("Hellion", Hellion);
    }

    @FXML
    void HighwaymanClick(MouseEvent event) throws IOException {
        Heroes Highwayman = new Heroes("Highwayman");
        Main.Window("Highwayman", Highwayman);
    }

    @FXML
    void HoundmasterClick(MouseEvent event) throws IOException {
        Heroes Houndmaster = new Heroes("Houndmaster");
        Main.Window("Houndmaster", Houndmaster);
    }

    @FXML
    void JesterClick(MouseEvent event) throws IOException {
        Heroes Jester = new Heroes("Jester");
        Main.Window("Jester", Jester);
    }

    @FXML
    void LeperClick(MouseEvent event) throws IOException {
        Heroes Leper = new Heroes("Leper");
        Main.Window("Leper", Leper);
    }

    @FXML
    void ManClick(MouseEvent event) throws IOException {
        Heroes ManAtArms = new Heroes("Man-at-Arms");
        Main.Window("Man-at-Arms", ManAtArms);
    }

    @FXML
    void OccultistClick(MouseEvent event) throws IOException {
        Heroes Occultist = new Heroes("Occultist");
        Main.Window("Occultist", Occultist);
    }

    @FXML
    void ShieldbreakerClick(MouseEvent event) throws IOException {
        Heroes Shieldbreaker = new Heroes("Shieldbreaker");
        Main.Window("Shieldbreaker", Shieldbreaker);
    }

    @FXML
    void VestalClick(MouseEvent event) throws IOException {
        Heroes Vestal = new Heroes("Vestal");
        Main.Window("Vestal", Vestal);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
