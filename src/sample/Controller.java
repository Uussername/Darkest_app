package sample;

import javafx.fxml.FXML;
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

import java.io.IOException;

public class Controller {

    @FXML
    private VBox window;

    @FXML
    private AnchorPane Anchorpane;

    @FXML
    private Rectangle background;

    @FXML
    private ImageView Logo;

    @FXML
    private ImageView imageBountyHunter;

    @FXML
    private ImageView imageAbomination;

    @FXML
    private ImageView imagePlagueDoctor;

    @FXML
    private ImageView imageGraveRobber;

    @FXML
    private ImageView imageLeper;

    @FXML
    private ImageView imageOccultist;

    @FXML
    private ImageView imageShieldbreaker;

    @FXML
    private ImageView imageAntiquarian;

    @FXML
    private ImageView imageHoundmaster;

    @FXML
    private ImageView imageArbalest;

    @FXML
    private ImageView imageCrusader;

    @FXML
    private ImageView imageManAtArms;

    @FXML
    private ImageView imageJester;

    @FXML
    private ImageView imageHellion;

    @FXML
    private ImageView imageHighwayman;

    @FXML
    private ImageView imageVestal;

    @FXML
    private ImageView imageFlagellant;

    @FXML
    private Label labelAbomination;

    @FXML
    private Label labelAntiquarian;

    @FXML
    private Label labelArbalest;

    @FXML
    private Label labelBountyHunter;

    @FXML
    private Label labelCrusader;

    @FXML
    private Label labelFlagellant;

    @FXML
    private Label labelGraveRobber;

    @FXML
    private Label labelHellion;

    @FXML
    private Label labelHighwayman;

    @FXML
    private Label labelHoundmaster;

    @FXML
    private Label labelJester;

    @FXML
    private Label labelLeper;

    @FXML
    private Label labelManAtArms;

    @FXML
    private Label labelOccultist;

    @FXML
    private Label labelPlagueDoctor;

    @FXML
    private Label labelShieldbreaker;

    @FXML
    private Label labelVestal;


    @FXML
    void AbominationClick(MouseEvent event) throws IOException {
        Main.Bain("Abomination");

    }

    @FXML
    void AntiquarianClick(MouseEvent event) throws IOException {
        Main.Bain("Antiquarian");

    }

    @FXML
    void ArbalestClick(MouseEvent event) throws IOException {
        Main.Bain("Arbalest");
    }

    @FXML
    void BountyHunterClick(MouseEvent event) throws IOException {
        Main.Bain("Bounty_Hunter");
    }

    @FXML
    void CrusaderClick(MouseEvent event) throws IOException {
        Main.Bain("Crusader");
    }

    @FXML
    void DoctorClick(MouseEvent event) throws IOException {
        Main.Bain("Plague_Doctor");
    }

    @FXML
    void FlagellantClick(MouseEvent event) throws IOException {
        Main.Bain("Flagellant");
    }

    @FXML
    void GraveRobberClick(MouseEvent event) throws IOException {
        Main.Bain("Grave_Robber");
    }

    @FXML
    void HellionClick(MouseEvent event) throws IOException {
        Main.Bain("Hellion");
    }

    @FXML
    void HighwaymanClick(MouseEvent event) throws IOException {
        Main.Bain("Highwayman");
    }

    @FXML
    void HoundmasterClick(MouseEvent event) throws IOException {
        Main.Bain("Houndmaster");
    }

    @FXML
    void JesterClick(MouseEvent event) throws IOException {
        Main.Bain("Jester");
    }

    @FXML
    void LeperClick(MouseEvent event) throws IOException {
        Main.Bain("Leper");
    }

    @FXML
    void ManClick(MouseEvent event) throws IOException {
        Main.Bain("Man-at-Arms");
    }

    @FXML
    void OccultistClick(MouseEvent event) throws IOException {
        Main.Bain("Occultist");
    }

    @FXML
    void ShieldbreakerClick(MouseEvent event) throws IOException {
        Main.Bain("Shieldbreaker");
    }

    @FXML
    void VestalClick(MouseEvent event) throws IOException {
        Main.Bain("Vestal");
    }
    @FXML
    private ImageView Portrait;

    @FXML
    private ComboBox<?> LevelBox;

    @FXML
    private Label HeroName;

    @FXML
    private TableView<?> BaseStats;

    @FXML
    private TableColumn<?, ?> Catagroy;

    @FXML
    private TableColumn<?, ?> Stats;

    @FXML
    private TableView<?> Skill;

    @FXML
    private TableColumn<?, ?> Column1;

    @FXML
    private TableColumn<?, ?> Column2;

    @FXML
    private TableColumn<?, ?> Column3;

    @FXML
    private TableColumn<?, ?> Column4;

    @FXML
    private TableColumn<?, ?> Column5;

    @FXML
    private TableColumn<?, ?> Column6;

    @FXML
    private TableColumn<?, ?> Column7;

    @FXML
    private TableColumn<?, ?> Column8;

    @FXML
    private Button SaveButton;

    @FXML
    private Button LoadButton;

    @FXML
    private Label SkillName;

    @FXML
    private Label SkillName1;

    @FXML
    private Label SkillName2;

    @FXML
    private Label SkillName3;

    @FXML
    private Label SkillName4;

    @FXML
    private Label SkillName5;

    @FXML
    private Label SkillName6;

    @FXML
    private Label SkillName7;

    @FXML
    private CheckBox SkillCheck;

    @FXML
    private CheckBox SkillCheck1;

    @FXML
    private CheckBox SkillCheck2;

    @FXML
    private CheckBox SkillCheck3;

    @FXML
    private CheckBox SkillCheck4;

    @FXML
    private CheckBox SkillCheck5;

    @FXML
    private CheckBox SkillCheck7;

    @FXML
    private CheckBox SkillCheck6;

    @FXML
    private TableView<?> Skill1;

    @FXML
    private TableColumn<?, ?> Column11;

    @FXML
    private TableColumn<?, ?> Column21;

    @FXML
    private TableColumn<?, ?> Column31;

    @FXML
    private TableColumn<?, ?> Column41;

    @FXML
    private TableColumn<?, ?> Column51;

    @FXML
    private TableColumn<?, ?> Column61;

    @FXML
    private TableColumn<?, ?> Column71;

    @FXML
    private TableColumn<?, ?> Column81;

    @FXML
    private TableView<?> Skill2;

    @FXML
    private TableColumn<?, ?> Column12;

    @FXML
    private TableColumn<?, ?> Column22;

    @FXML
    private TableColumn<?, ?> Column32;

    @FXML
    private TableColumn<?, ?> Column42;

    @FXML
    private TableColumn<?, ?> Column52;

    @FXML
    private TableColumn<?, ?> Column62;

    @FXML
    private TableColumn<?, ?> Column72;

    @FXML
    private TableColumn<?, ?> Column82;

    @FXML
    private TableView<?> Skill3;

    @FXML
    private TableColumn<?, ?> Column13;

    @FXML
    private TableColumn<?, ?> Column23;

    @FXML
    private TableColumn<?, ?> Column33;

    @FXML
    private TableColumn<?, ?> Column43;

    @FXML
    private TableColumn<?, ?> Column53;

    @FXML
    private TableColumn<?, ?> Column63;

    @FXML
    private TableColumn<?, ?> Column73;

    @FXML
    private TableColumn<?, ?> Column83;

    @FXML
    private TableView<?> Skill4;

    @FXML
    private TableColumn<?, ?> Column14;

    @FXML
    private TableColumn<?, ?> Column24;

    @FXML
    private TableColumn<?, ?> Column34;

    @FXML
    private TableColumn<?, ?> Column44;

    @FXML
    private TableColumn<?, ?> Column54;

    @FXML
    private TableColumn<?, ?> Column64;

    @FXML
    private TableColumn<?, ?> Column74;

    @FXML
    private TableColumn<?, ?> Column84;

    @FXML
    private TableView<?> Skill5;

    @FXML
    private TableColumn<?, ?> Column15;

    @FXML
    private TableColumn<?, ?> Column25;

    @FXML
    private TableColumn<?, ?> Column35;

    @FXML
    private TableColumn<?, ?> Column45;

    @FXML
    private TableColumn<?, ?> Column55;

    @FXML
    private TableColumn<?, ?> Column65;

    @FXML
    private TableColumn<?, ?> Column75;

    @FXML
    private TableColumn<?, ?> Column85;

    @FXML
    private TableView<?> Skill6;

    @FXML
    private TableColumn<?, ?> Column16;

    @FXML
    private TableColumn<?, ?> Column26;

    @FXML
    private TableColumn<?, ?> Column36;

    @FXML
    private TableColumn<?, ?> Column46;

    @FXML
    private TableColumn<?, ?> Column56;

    @FXML
    private TableColumn<?, ?> Column66;

    @FXML
    private TableColumn<?, ?> Column76;

    @FXML
    private TableColumn<?, ?> Column86;

    @FXML
    private TableView<?> Skill7;

    @FXML
    private TableColumn<?, ?> Column17;

    @FXML
    private TableColumn<?, ?> Column27;

    @FXML
    private TableColumn<?, ?> Column37;

    @FXML
    private TableColumn<?, ?> Column47;

    @FXML
    private TableColumn<?, ?> Column57;

    @FXML
    private TableColumn<?, ?> Column67;

    @FXML
    private TableColumn<?, ?> Column77;

    @FXML
    private TableColumn<?, ?> Column87;

    @FXML
    void LevelChange(ActionEvent event) {

    }

    @FXML
    void Load(ActionEvent event) {

    }

    @FXML
    void Save(ActionEvent event) {

    }

    @FXML
    void Skill1Checked(ActionEvent event) {

    }

    @FXML
    void Skill2Checked(ActionEvent event) {

    }

    @FXML
    void Skill3Checked(ActionEvent event) {

    }

    @FXML
    void Skill4Checked(ActionEvent event) {

    }

    @FXML
    void Skill5Checked(ActionEvent event) {

    }

    @FXML
    void Skill6Checked(ActionEvent event) {

    }

    @FXML
    void Skill7Checked(ActionEvent event) {

    }

    @FXML
    void Skill8Checked(ActionEvent event) {

    }
}

