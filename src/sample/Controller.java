package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableRow;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

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

    @FXML
    private TableView table;

    /**
     * Load button event, creates a new window  a table of  all saved heroes
     * a row can then be double clicked to load that hero's stats with Generic.fxml
     * @param event
     * @throws SQLException
     * @throws IOException
     */
    @FXML
    void Load(ActionEvent event) throws SQLException, IOException {
        Scene scene = new Scene(new Group());
        Stage stage = new Stage();
        table = new TableView();

        stage.setTitle("Roster");
        stage.setWidth(300);
        stage.setHeight(500);

        final Label label = new Label("Hero Roster");
        label.setFont(new Font("Arial", 20));

        table.setEditable(false);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        clicking(stage);
    }

    /**
     * Event for double clicking a row in the load window after clicking Load button
     * Opens the hero selected in Generic.Fxml with all their saved skills and level then closes the table window
     * @param primaryStage stage being worked with
     * @throws SQLException
     *
     *
     */
    public void clicking(Stage primaryStage) throws SQLException {
        TableView<ROW> table = new TableView<>();
        table.setRowFactory(tv -> {
            TableRow<ROW> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    ROW rowData = row.getItem();
                    try {

                        ArrayList<Integer> skills = DBconnections.select(DBconnections.connect(), rowData.Level.get());
                        Heroes hero = new Heroes(rowData.Catagory.get());
                        Main.load(rowData.Catagory.get(), hero, skills.get(0),skills.get(1), skills.get(2),
                                skills.get(3), skills.get(4),skills.get(5), skills.get(6),skills.get(7));
                        primaryStage.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            });
            return row ;
        });
        TableColumn HeroClass = new TableColumn("Hero Class");
        TableColumn HeroName = new TableColumn("Hero Name");
        table.getColumns().addAll(HeroClass, HeroName);

        final ObservableList<ROW> data = DBconnections.read(DBconnections.connect());
        HeroClass.setCellValueFactory(new PropertyValueFactory<ROW, String>("Catagory"));
        HeroName.setCellValueFactory(new PropertyValueFactory<ROW, String>("level"));
        table.setItems(data);

        Scene scene = new Scene(table);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
