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
        int x = 0;
        if (SkillCheck.isSelected()) {
            x = x+1;
        }
        if (SkillCheck1.isSelected()) {
            x = x+1;
        }
        if (SkillCheck2.isSelected()) {
            x = x+1;
        }
        if (SkillCheck3.isSelected()) {
            x = x+1;
        }
        if (SkillCheck4.isSelected()) {
            x = x+1;
        }
        if (SkillCheck5.isSelected()) {
            x = x+1;
        }
        if (SkillCheck6.isSelected()) {
            x = x+1;
        }
        if (x > 4){
            System.out.println("NO SOUP FOR YOU");
            return;
        }
        else {
            System.out.println("saved");
        }
    }

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
    private void Checkboxed(CheckBox box, int selector, Heroes hero) throws IOException {
        if (box.isSelected()) {

            Integer set = Heroes.RANKnum(hero, selector, 1) + Integer.parseInt(Prank1.getText());
            Integer that = Heroes.RANKnum(hero, selector, 2) + Integer.parseInt(Prank2.getText());
            Integer value = Heroes.RANKnum(hero, selector, 3) + Integer.parseInt(Prank3.getText());
            Integer thing = Heroes.RANKnum(hero, selector, 4) + Integer.parseInt(Prank4.getText());

            Integer A = Heroes.RANKtargetNUM(hero, selector, 5) + Integer.parseInt(Ptarget1.getText());
            Integer B = Heroes.RANKtargetNUM(hero, selector, 6) + Integer.parseInt(Ptarget2.getText());
            Integer C = Heroes.RANKtargetNUM(hero, selector, 7) + Integer.parseInt(Ptarget3.getText());
            Integer D = Heroes.RANKtargetNUM(hero, selector, 8) + Integer.parseInt(Ptarget4.getText());

            if (Integer.parseInt(Prank1.getText())== 4
                    || Integer.parseInt(Prank2.getText()) == 4
                    || Integer.parseInt(Prank3.getText()) == 4
                    || Integer.parseInt(Prank4.getText()) == 4)
            {
                box.setSelected(false);
                return;
            }
            else{
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LevelBox.getItems().addAll(1, 2, 3, 4, 5);
    }
}


