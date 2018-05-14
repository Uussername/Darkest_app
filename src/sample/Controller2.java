package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import java.sql.*;

/**
 * Controller class for Generic.fxml
 * Contains event methods for the GUI, methods on repeated code, and a method for the first Controller
 */

public class Controller2 implements Initializable {
    /**
     * initializing FX:id names
     * Labels, ImageView, ComboBox, TableViews, CheckBoxes and Buttons
     */

    @FXML
    private ImageView Portrait;

    @FXML
    private ComboBox<Integer> LevelBox;

    @FXML
    private Label HeroName;

    @FXML
    private Label Jank;

    @FXML
    private TableView<ROW> BaseStats;

        @FXML
        private TableColumn<ROW, String> Catagroy;

        @FXML
        private TableColumn<ROW, String> Stats;

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
    private Label Prank1;

    @FXML
    private Label Prank2;

    @FXML
    private Label Prank3;

    @FXML
    private Label Prank4;

    @FXML
    private Label Ptarget1;

    @FXML
    private Label Ptarget2;

    @FXML
    private Label Ptarget3;

    @FXML
    private Label Ptarget4;

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
    private CheckBox SkillCheck6;

    @FXML
    private TableView<ROWskill> Skill;

    @FXML
    private TableView<ROWskill> Skill1;

    @FXML
    private TableView<ROWskill> Skill2;

    @FXML
    private TableView<ROWskill> Skill3;

    @FXML
    private TableView<ROWskill> Skill4;

    @FXML
    private TableView<ROWskill> Skill5;

    @FXML
    private TableView<ROWskill> Skill6;

    /**
     * Occurs when the ComboBox in Generic.fxml is changed to a new value
     * Clears all skill tables and recreates them
     * (somewhat unfinished, all tables would ideally show different information per level
     * not just he base stats table)
     *
     * @param event
     * @throws IOException
     * Clears Skill tableViews 0-6
     * Creates a new Heroes object from the Label Jank
     * Runs set table on Hero object to set the base stats based on the number in the combo box
     * Runs TableFinder on Hero object, to fill the table in param,
     *      with a prefound selector value to obtain the correct info
     *
     * Return
     */
    @FXML
    void LevelChange(ActionEvent event) throws IOException {
        Skill.getColumns().clear();
        Skill1.getColumns().clear();
        Skill2.getColumns().clear();
        Skill3.getColumns().clear();
        Skill4.getColumns().clear();
        Skill5.getColumns().clear();
        Skill6.getColumns().clear();

        Heroes hero = new Heroes(Jank.getText());
        SetTable(hero, LevelBox.getValue());
        TableFinder(hero, Skill, 1);
        TableFinder(hero, Skill1, 3);
        TableFinder(hero, Skill2, 5);
        TableFinder(hero, Skill3, 7);
        TableFinder(hero, Skill4, 9);
        TableFinder(hero, Skill5, 11);
        TableFinder(hero, Skill6, 13);
    }

    @FXML
    void Save(ActionEvent event) throws SQLException {
        int x = 0;
        int A = 0, B = 0, C = 0, D = 0, E = 0, F = 0, G = 0 ;
        if (SkillCheck.isSelected()) {
            x = x+1;
            A = 1;
        }
        if (SkillCheck1.isSelected()) {
            x = x+1;
            B = 1;
        }
        if (SkillCheck2.isSelected()) {
            x = x+1;
            C = 1;
        }
        if (SkillCheck3.isSelected()) {
            x = x+1;
            D = 1;
        }
        if (SkillCheck4.isSelected()) {
            x = x+1;
            E = 1;
        }
        if (SkillCheck5.isSelected()) {
            x = x+1;
            F = 1;
        }
        if (SkillCheck6.isSelected()) {
            x = x+1;
            G = 1;
        }
        if (x != 4){
            Error("Hero must have only 4 skills selected");
            return;
        }
        if (LevelBox.getSelectionModel().isEmpty()) {
            Error("Resolve level must be selected");
            return;
        }
        else {
            TextInputDialog dialog = new TextInputDialog("");
            dialog.setTitle("Hero Name");
            dialog.setHeaderText("Give your hero a unique name");
            dialog.setContentText("Please name your hero:");

            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()){
                if (result.toString().equals("Optional[]")){
                    Error("Hero must have a name");
                    return;
                }
                Connection Con = DBconnections.connect();
                    if (DBconnections.UniqueSelect(Con, result).equals(false)){
                        Error("Hero must have a UNIQUE name");
                        return;
                    }
                    DBconnections.insert(Con, Jank.getText(), result.get(),LevelBox.getValue(), A, B, C, D, E, F, G);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText(null);
                    alert.setContentText("Hero saved into database");
                    alert.showAndWait();
                }
            else {
                return;
            }
        }

    }

    /**
     * Occurs when a skill box is checked, Same code is run on each Checkbox event
     *
     * @param event
     * @throws IOException
     *
     * Create a new Heroes object from the label Jank
     * Runs Checkboxed on corresponding checkbox per event with Heroes object and number of table
     *
     * Return
     */

    @FXML
    void Skill1Checked(ActionEvent event) throws IOException {
        Heroes hero = new Heroes(Jank.getText());
        Checkboxed(SkillCheck, 1, hero);
    }

    @FXML
    void Skill2Checked(ActionEvent event) throws IOException {
        Heroes hero = new Heroes(Jank.getText());
        Checkboxed(SkillCheck1, 3, hero);
    }

    @FXML
    void Skill3Checked(ActionEvent event) throws IOException {
        Heroes hero = new Heroes(Jank.getText());
        Checkboxed(SkillCheck2, 5, hero);
    }

    @FXML
    void Skill4Checked(ActionEvent event) throws IOException {
        Heroes hero = new Heroes(Jank.getText());
        Checkboxed(SkillCheck3, 7, hero);
    }

    @FXML
    void Skill5Checked(ActionEvent event) throws IOException {
        Heroes hero = new Heroes(Jank.getText());
        Checkboxed(SkillCheck4, 9, hero);
    }

    @FXML
    void Skill6Checked(ActionEvent event) throws IOException {
        Heroes hero = new Heroes(Jank.getText());
        Checkboxed(SkillCheck5, 11, hero);
    }

    @FXML
    void Skill7Checked(ActionEvent event) throws IOException {
        Heroes hero = new Heroes(Jank.getText());
        Checkboxed(SkillCheck6, 13, hero);
    }

    /**
     * A method for the Controller.java to set various labels based on the image clicked in Dark.fxml
     *
     * @param hero the table Elements of the web page being scrapped, an Object
     * @param name name of the Hero that is being scrapped, used for URL endings
     *
     * Sets a title text to the name of the hero
     * Sets a small hidden label to a specific string to be used to create more of the same object
     * Sets each smaller table titles
     * Sets the Hero image to that on their page
     *
     */

    public void SetValues(Heroes hero, String name) {

        //setting labels
        this.HeroName.setText(hero.Base.select("tr").first().text());
        // setting the important jank label
        this.Jank.setText(name);
        // setting skill names
        this.SkillName.setText(hero.skills.get(1).select("tr").first().text());
        this.SkillName1.setText(hero.skills.get(3).select("tr").first().text());
        this.SkillName2.setText(hero.skills.get(5).select("tr").first().text());
        this.SkillName3.setText(hero.skills.get(7).select("tr").first().text());
        this.SkillName4.setText(hero.skills.get(9).select("tr").first().text());
        this.SkillName5.setText(hero.skills.get(11).select("tr").first().text());
        this.SkillName6.setText(hero.skills.get(13).select("tr").first().text());

        //setting label
        Image image = new Image(hero.Base.select("img").attr("src"));
        this.Portrait.setImage(image);

    }

    /**
     * Much like SetValues but is used to load a hero, thus sets more values to effectively reload the program state
     * runs several event methods to do this
     *
     * @param hero elements from webpage
     * @param name name of the window used by SetValues
     * @param level level number in combobox
     * @param A Whether or not that checkbox was checked 1 true, 0 false
     * @param B Whether or not that checkbox was checked 1 true, 0 false
     * @param C Whether or not that checkbox was checked 1 true, 0 false
     * @param D Whether or not that checkbox was checked 1 true, 0 false
     * @param E Whether or not that checkbox was checked 1 true, 0 false
     * @param F Whether or not that checkbox was checked 1 true, 0 false
     * @param G Whether or not that checkbox was checked 1 true, 0 false
     *
     * checks each int value against its corrisponding combo box to see if it was checked
     *          if it was, makes the combobox true and runs the event
     * Sets the combobox
     */
    public void LoadingHero(Heroes hero, String name, int level, int A, int B, int C, int D, int E, int F, int G){
        SetValues(hero, name);
        if(A == 1) {
            this.SkillCheck.setSelected(true);
            Checkboxed(SkillCheck, 1, hero);
        }
        if(B == 1) {
            this.SkillCheck1.setSelected(true);
            Checkboxed(SkillCheck1, 3, hero);
        }
        if(C == 1) {
            this.SkillCheck2.setSelected(true);
            Checkboxed(SkillCheck2, 5, hero);
        }
        if(D == 1) {
            this.SkillCheck3.setSelected(true);
            Checkboxed(SkillCheck3, 7, hero);
        }
        if(E == 1) {
            this.SkillCheck4.setSelected(true);
            Checkboxed(SkillCheck4, 9, hero);
        }
        if(F == 1) {
            this.SkillCheck5.setSelected(true);
            Checkboxed(SkillCheck5, 11, hero);
        }
        if(G == 1) {
            this.SkillCheck6.setSelected(true);
            Checkboxed(SkillCheck6, 13, hero);
        }
        this.LevelBox.getSelectionModel().select(level-1);
        SetTable(hero, LevelBox.getValue());
        TableFinder(hero, this.Skill, 1);
        TableFinder(hero, this.Skill1, 3);
        TableFinder(hero, this.Skill2, 5);
        TableFinder(hero, this.Skill3, 7);
        TableFinder(hero, this.Skill4, 9);
        TableFinder(hero, this.Skill5, 11);
        TableFinder(hero, this.Skill6, 13);
    }

    /**
     * Sets the baseStats table on the left of the Generic.fxml
     *
     * @param hero object that contains site table elements
     * @param Num the column of data to return
     *
     * creates 2 array lists, 1 for the row titles, 1 of actual data
     * Creates an observableList of ROW object to be used creating the table
     * for loop, 18 iterations
     *             creates a ROW object of just a singular item of each ArrayList
     *             adds them to the ObservableList
     * Creates 2 cell factories and sets the table data
     *
     */
    private void SetTable(Heroes hero, int Num) {
        ArrayList<String> FIRST = Heroes.statList(hero, 0,0);
        ArrayList<String> SECOND = Heroes.statList(hero, Num,1);


        final ObservableList<ROW> data = FXCollections.observableArrayList();
        for (int x = 1; x < 18; x++) {
            ROW item = new ROW(FIRST.get(x), SECOND.get(x));
            data.add(item);
        }

        Catagroy.setCellValueFactory(
                new PropertyValueFactory<ROW, String>("Catagory")
        );
        Stats.setCellValueFactory(
                new PropertyValueFactory<ROW, String>("level"));
        BaseStats.setItems(data);
    }

    /**
     * Similar to SetTable only for each skill, with up to 9 columns instead of 2
     * @param hero elements of site
     * @param tabs the TableView being edited
     * @param selector skill table for hero
     *
     * creates 7 array lists, each for data
     *      Creates an observableList of ROW object to be used creating the table
     *      for loop, 18 iterations
     *                  creates a ROWskill object of just a singular item of each ArrayList
     *                  adds them to the ObservableList
     *      Creates 7 cell factories and sets the table data
     */
    private void SkillTable(Heroes hero, TableView<ROWskill> tabs, int selector){
        ArrayList<String> skill = Heroes.skillsListDamage(hero,1, selector );
        ArrayList<String> skill2 = Heroes.skillsListDamage(hero,2,selector );
        ArrayList<String> skill3 = Heroes.skillsListDamage(hero,3,selector );
        ArrayList<String> skill4 = Heroes.skillsListDamage(hero,4,selector);
        ArrayList<String> skill5 = Heroes.skillsListDamage(hero,5 ,selector);
        ArrayList<String> skill6 = Heroes.skillsListDamage(hero,6 ,selector);
        ArrayList<String> skill7 = Heroes.skillsListDamage(hero,7 ,selector);
        ArrayList<String> skill8 = Heroes.skillsListDamage(hero,8 ,selector);

        final ObservableList<ROWskill> data = FXCollections.observableArrayList();
            ROWskill item = new ROWskill(skill.get(1), skill2.get(1), skill3.get(1), skill4.get(1), skill5.get(1), skill6.get(1), skill7.get(1), skill8.get(1));
            data.add(item);
        TableColumn one = new TableColumn(skill.get(0));
        TableColumn two = new TableColumn(skill2.get(0));
        TableColumn three = new TableColumn(skill3.get(0));
        TableColumn four = new TableColumn(skill4.get(0));
        TableColumn five = new TableColumn(skill5.get(0));
        TableColumn six = new TableColumn(skill6.get(0));
        TableColumn seven = new TableColumn(skill7.get(0));
        TableColumn eight = new TableColumn(skill8.get(0));

        tabs.getColumns().addAll(one, two, three, four, five, six, seven, eight);

            one.setCellValueFactory(
                    new PropertyValueFactory<ROWskill, String>("first"));
            two.setCellValueFactory(
                    new PropertyValueFactory<ROWskill, String>("Second"));
            three.setCellValueFactory(
                new PropertyValueFactory<ROWskill, String>("Third"));
            four.setCellValueFactory(
                new PropertyValueFactory<ROWskill, String>("Fourth"));
            five.setCellValueFactory(
                new PropertyValueFactory<ROWskill, String>("Fifth"));
            six.setCellValueFactory(
                new PropertyValueFactory<ROWskill, String>("Sixth"));
            seven.setCellValueFactory(
                new PropertyValueFactory<ROWskill, String>("Seventh"));
            eight.setCellValueFactory(
                new PropertyValueFactory<ROWskill, String>("Eighth"));
            tabs.setItems(data);

    }

    /**
     * Nearly identical to SkillTable, except the amount of lists and columns created is 4
     *
     * @param hero elements of site
     * @param tabs the TableView being edited
     * @param selector skill table for hero
     *
     */
    private void SkillTableBUFF(Heroes hero, TableView<ROWskill> tabs, int selector){
        ArrayList<String> skill = Heroes.SkillListBuff(hero,1, selector );
        ArrayList<String> skill2 = Heroes.SkillListBuff(hero,2,selector );
        ArrayList<String> skill3 = Heroes.SkillListBuff(hero,3,selector );
        ArrayList<String> skill4 = Heroes.SkillListBuff(hero,4,selector);

        final ObservableList<ROWskill> data = FXCollections.observableArrayList();
        ROWskill item = new ROWskill(skill.get(1), skill2.get(1), skill3.get(1), skill4.get(1));
        data.add(item);
        TableColumn one = new TableColumn(skill.get(0));
        TableColumn two = new TableColumn(skill2.get(0));
        TableColumn three = new TableColumn(skill3.get(0));
        TableColumn four = new TableColumn(skill4.get(0));

        tabs.getColumns().addAll(one, two, three, four);

        one.setCellValueFactory(
                new PropertyValueFactory<ROWskill, String>("first"));
        two.setCellValueFactory(
                new PropertyValueFactory<ROWskill, String>("Second"));
        three.setCellValueFactory(
                new PropertyValueFactory<ROWskill, String>("Third"));
        four.setCellValueFactory(
                new PropertyValueFactory<ROWskill, String>("Fourth"));
        tabs.setItems(data);
    }
    /**
     * Nearly identical to SkillTable, except the amount of lists and columns created is 6
     *
     * @param hero elements of site
     * @param tabs the TableView being edited
     * @param selector skill table for hero
     *
     */
    private void SkillTableHEAL(Heroes hero, TableView<ROWskill> tabs, int selector){
        ArrayList<String> skill = Heroes.SkillListBuff(hero,1, selector );
        ArrayList<String> skill2 = Heroes.SkillListBuff(hero,2,selector );
        ArrayList<String> skill3 = Heroes.SkillListBuff(hero,3,selector );
        ArrayList<String> skill4 = Heroes.SkillListBuff(hero,4,selector);
        ArrayList<String> skill5 = Heroes.SkillListBuff(hero,5 ,selector);
        ArrayList<String> skill6 = Heroes.SkillListBuff(hero,6 ,selector);

        final ObservableList<ROWskill> data = FXCollections.observableArrayList();
        ROWskill item = new ROWskill(skill.get(1), skill2.get(1), skill3.get(1), skill4.get(1), skill5.get(1), skill6.get(1));
        data.add(item);
        TableColumn one = new TableColumn(skill.get(0));
        TableColumn two = new TableColumn(skill2.get(0));
        TableColumn three = new TableColumn(skill3.get(0));
        TableColumn four = new TableColumn(skill4.get(0));
        TableColumn five = new TableColumn(skill5.get(0));
        TableColumn six = new TableColumn(skill6.get(0));

        tabs.getColumns().addAll(one, two, three, four, five, six);

        one.setCellValueFactory(
                new PropertyValueFactory<ROWskill, String>("first"));
        two.setCellValueFactory(
                new PropertyValueFactory<ROWskill, String>("Second"));
        three.setCellValueFactory(
                new PropertyValueFactory<ROWskill, String>("Third"));
        four.setCellValueFactory(
                new PropertyValueFactory<ROWskill, String>("Fourth"));
        five.setCellValueFactory(
                new PropertyValueFactory<ROWskill, String>("Fifth"));
        six.setCellValueFactory(
                new PropertyValueFactory<ROWskill, String>("Sixth"));

        tabs.setItems(data);
    }

    /**
     * Finds the type of table method to run based on the color of the title of each table on the site
     * SkillTable for red, SkillTableBUFF for blue, and SkillTableHEAL for green
     *
     * @param hero elements from webpage
     * @param tabs the TableView being edited
     * @param selector skill table for hero
     *
     */
    private void TableFinder(Heroes hero, TableView<ROWskill> tabs, int selector){
        if (hero.skills.get(selector).select("th").first().attr("style").equals(
                    "color:#FFFFFF;font-weight:bold;background-color:#610804;min-width:590px;")){
                SkillTable(hero, tabs, selector);
        }
        if (hero.skills.get(selector).select("th").first().attr("style").equals(
                "color:#FFFFFF;font-weight:bold;background-color:#267396;")) {
            SkillTableBUFF(hero, tabs, selector);
        }
        if (hero.skills.get(selector).select("th").first().attr("style").equals(
                "color:#FFFFFF;font-weight:bold;background-color:#005C00;")) {
            SkillTableHEAL(hero, tabs, selector);
        }
    }

    /**
     * Method for checkboxes to find ideal position and target
     * takes the each of the Current Prank and Ptarget labels and adds or subtracts a value based
     * on whether it was checked or unchecked
     *
     * @param box the checkbox
     * @param selector number of skill table
     * @param hero elements from webpage
     *
     * when being checked
     *      finds the value of each rank and target from Ranknum and RANKtarget methods in Heroes
     *      Checks to make sure non of the labels would increase in value over 4
     *             if they would increase, prevent the checkbox from being checked
     *             if not, change the labels to the new value
     * when being unchecked
     *      finds the value of each rank and target from Ranknum and RANKtarget methods in Heroes
     *      subtracts the calculated value from the current label values
     *      sets labels to new calculated value
     */
    private void Checkboxed(CheckBox box, int selector, Heroes hero) {
        if (box.isSelected()) {

            Integer set = Heroes.RANKnum(hero, selector, 1) + Integer.parseInt(Prank1.getText());
            Integer that = Heroes.RANKnum(hero, selector, 2) + Integer.parseInt(Prank2.getText());
            Integer value = Heroes.RANKnum(hero, selector, 3) + Integer.parseInt(Prank3.getText());
            Integer thing = Heroes.RANKnum(hero, selector, 4) + Integer.parseInt(Prank4.getText());

            Integer A = Heroes.RANKtargetNUM(hero, selector, 5) + Integer.parseInt(Ptarget1.getText());
            Integer B = Heroes.RANKtargetNUM(hero, selector, 6) + Integer.parseInt(Ptarget2.getText());
            Integer C = Heroes.RANKtargetNUM(hero, selector, 7) + Integer.parseInt(Ptarget3.getText());
            Integer D = Heroes.RANKtargetNUM(hero, selector, 8) + Integer.parseInt(Ptarget4.getText());

            //preventing label change
            if (Integer.parseInt(Prank1.getText())== 4
                    || Integer.parseInt(Prank2.getText()) == 4
                    || Integer.parseInt(Prank3.getText()) == 4
                    || Integer.parseInt(Prank4.getText()) == 4)
            {
                box.setSelected(false);
                return;
            }
            else{
                //changing labels

                Prank1.setText(set.toString());
                Prank2.setText(that.toString());
                Prank3.setText(value.toString());
                Prank4.setText(thing.toString());

                Ptarget1.setText(A.toString());
                Ptarget2.setText(B.toString());
                Ptarget3.setText(C.toString());
                Ptarget4.setText(D.toString());
            }
        }
        if (!box.isSelected()) {
            //finding values and subtracting from the label
            Integer have = Integer.parseInt(Prank1.getText()) - Heroes.RANKnum(hero, selector, 1);
            Prank1.setText(have.toString());
            Integer the = Integer.parseInt(Prank2.getText()) - Heroes.RANKnum(hero, selector, 2);
            Prank2.setText(the.toString());
            Integer best = Integer.parseInt(Prank3.getText()) - Heroes.RANKnum(hero, selector, 3);
            Prank3.setText( best.toString());
            Integer day = Integer.parseInt(Prank4.getText()) - Heroes.RANKnum(hero, selector, 4);
            Prank4.setText(day.toString());

            Integer E = Integer.parseInt(Ptarget1.getText()) - Heroes.RANKtargetNUM(hero, selector, 5);
            Ptarget1.setText(E.toString());
            Integer F = Integer.parseInt(Ptarget2.getText()) - Heroes.RANKtargetNUM(hero, selector, 6);
            Ptarget2.setText(F.toString());
            Integer G = Integer.parseInt(Ptarget3.getText()) - Heroes.RANKtargetNUM(hero, selector, 7);
            Ptarget3.setText( G.toString());
            Integer H = Integer.parseInt(Ptarget4.getText()) - Heroes.RANKtargetNUM(hero, selector, 8);
            Ptarget4.setText(H.toString());

        }
    }
    private void Error(String Error){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(Error);
        alert.showAndWait();
    }

    /**
     * initial startup of the window
     * sets up the levelbox
     *
     * @param location a default for custom initialization
     * @param resources a default for custom initialization
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LevelBox.getItems().addAll(1, 2, 3, 4, 5);
    }
}


