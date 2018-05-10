package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;

public class Controller2 implements Initializable {

    @FXML
    public ImageView Portrait;

    @FXML
    public ComboBox<Integer> LevelBox;

    @FXML
    public Label HeroName;

    @FXML
    public Label Jank;

    @FXML
    public TableView<ROW> BaseStats;

        @FXML
        public TableColumn<ROW, String> Catagroy;

        @FXML
        public TableColumn<ROW, String> Stats;

    @FXML
    public Button SaveButton;

    @FXML
    public Button LoadButton;

    @FXML
    public Label SkillName;

    @FXML
    public Label SkillName1;

    @FXML
    public Label SkillName2;

    @FXML
    public Label SkillName3;

    @FXML
    public Label SkillName4;

    @FXML
    public Label SkillName5;

    @FXML
    public Label SkillName6;

    @FXML
    public Label Prank1;

    @FXML
    public Label Prank2;

    @FXML
    public Label Prank3;

    @FXML
    public Label Prank4;

    @FXML
    public Label Ptarget1;

    @FXML
    public Label Ptarget2;

    @FXML
    public Label Ptarget3;

    @FXML
    public Label Ptarget4;

    @FXML
    public CheckBox SkillCheck;

    @FXML
    public CheckBox SkillCheck1;

    @FXML
    public CheckBox SkillCheck2;

    @FXML
    public CheckBox SkillCheck3;

    @FXML
    public CheckBox SkillCheck4;

    @FXML
    public CheckBox SkillCheck5;

    @FXML
    public CheckBox SkillCheck7;

    @FXML
    public CheckBox SkillCheck6;

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
    void Load(ActionEvent event) {

    }

    @FXML
    void Save(ActionEvent event) {

    }

    @FXML
    void Skill1Checked(ActionEvent event) throws IOException {
        if (SkillCheck.isSelected()) {
            Heroes hero = new Heroes(Jank.getText());
            Prank1.setText(Heroes.RANKnum(hero, 1, 1).toString());
            Prank2.setText(Heroes.RANKnum(hero, 1, 2).toString());
            Prank3.setText(Heroes.RANKnum(hero, 1, 3).toString());
            Prank4.setText(Heroes.RANKnum(hero, 1, 4).toString());


            Ptarget1.setText(Heroes.RANK(hero, 1));
        }
        if (!SkillCheck.isSelected()){
            Prank1.setText("");
            Ptarget1.setText("");
        }
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
    public void SetValues(Heroes hero, String name) throws FileNotFoundException {

        //setting labels
        this.HeroName.setText(hero.Base.select("tr").first().text());
        this.Jank.setText(name);
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
    public void SetTable(Heroes hero, int Num) {
        ArrayList<String> FIRST = Heroes.statList(hero, 0);
        ArrayList<String> SECOND = Heroes.statList2(hero, Num);


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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LevelBox.getItems().addAll(1, 2, 3, 4, 5);
    }
}


