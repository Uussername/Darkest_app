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
import java.util.EventObject;
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
    public TableView<?> Skill;

        @FXML
        public TableColumn<?, ?> Column1;

        @FXML
        public TableColumn<?, ?> Column2;

        @FXML
        public TableColumn<?, ?> Column3;

        @FXML
        public TableColumn<?, ?> Column4;

        @FXML
        public TableColumn<?, ?> Column5;

        @FXML
        public TableColumn<?, ?> Column6;

        @FXML
        public TableColumn<?, ?> Column7;

        @FXML
        public TableColumn<?, ?> Column8;

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
    public TableView<?> Skill1;

        @FXML
        public TableColumn<?, ?> Column11;

        @FXML
        public TableColumn<?, ?> Column21;

        @FXML
        public TableColumn<?, ?> Column31;

        @FXML
        public TableColumn<?, ?> Column41;

        @FXML
        public TableColumn<?, ?> Column51;

        @FXML
        public TableColumn<?, ?> Column61;

        @FXML
        public TableColumn<?, ?> Column71;

        @FXML
        public TableColumn<?, ?> Column81;

    @FXML
    public TableView<?> Skill2;

        @FXML
        public TableColumn<?, ?> Column12;

        @FXML
        public TableColumn<?, ?> Column22;

        @FXML
        public TableColumn<?, ?> Column32;

        @FXML
        public TableColumn<?, ?> Column42;

        @FXML
        public TableColumn<?, ?> Column52;

        @FXML
        public TableColumn<?, ?> Column62;

        @FXML
        public TableColumn<?, ?> Column72;

        @FXML
        public TableColumn<?, ?> Column82;

    @FXML
    public TableView<?> Skill3;

        @FXML
        public TableColumn<?, ?> Column13;

        @FXML
        public TableColumn<?, ?> Column23;

        @FXML
        public TableColumn<?, ?> Column33;

        @FXML
        public TableColumn<?, ?> Column43;

        @FXML
        public TableColumn<?, ?> Column53;

        @FXML
        public TableColumn<?, ?> Column63;

        @FXML
        public TableColumn<?, ?> Column73;

        @FXML
        public TableColumn<?, ?> Column83;

    @FXML
    public TableView<?> Skill4;

        @FXML
        public TableColumn<?, ?> Column14;

        @FXML
        public TableColumn<?, ?> Column24;

        @FXML
        public TableColumn<?, ?> Column34;

        @FXML
        public TableColumn<?, ?> Column44;

        @FXML
        public TableColumn<?, ?> Column54;

        @FXML
        public TableColumn<?, ?> Column64;

        @FXML
        public TableColumn<?, ?> Column74;

        @FXML
        public TableColumn<?, ?> Column84;

    @FXML
    public TableView<?> Skill5;

        @FXML
        public TableColumn<?, ?> Column15;

        @FXML
        public TableColumn<?, ?> Column25;

        @FXML
        public TableColumn<?, ?> Column35;

        @FXML
        public TableColumn<?, ?> Column45;

        @FXML
        public TableColumn<?, ?> Column55;

        @FXML
        public TableColumn<?, ?> Column65;

        @FXML
        public TableColumn<?, ?> Column75;

        @FXML
        public TableColumn<?, ?> Column85;

    @FXML
    public TableView<?> Skill6;

        @FXML
        public TableColumn<?, ?> Column16;

        @FXML
        public TableColumn<?, ?> Column26;

        @FXML
        public TableColumn<?, ?> Column36;

        @FXML
        public TableColumn<?, ?> Column46;

        @FXML
        public TableColumn<?, ?> Column56;

        @FXML
        public TableColumn<?, ?> Column66;

        @FXML
        public TableColumn<?, ?> Column76;

        @FXML
        public TableColumn<?, ?> Column86;

    @FXML
    public TableView<?> Skill7;

        @FXML
        public TableColumn<?, ?> Column17;

        @FXML
        public TableColumn<?, ?> Column27;

        @FXML
        public TableColumn<?, ?> Column37;

        @FXML
        public TableColumn<?, ?> Column47;

        @FXML
        public TableColumn<?, ?> Column57;

        @FXML
        public TableColumn<?, ?> Column67;

        @FXML
        public TableColumn<?, ?> Column77;

        @FXML
        public TableColumn<?, ?> Column87;


    @FXML
    void LevelChange(ActionEvent event) throws IOException {
        Heroes hero = new Heroes(Jank.getText());
        SetTable(hero, LevelBox.getValue());
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
    public void SetValues(Heroes hero, String name) throws FileNotFoundException {

        //setting labels
        this.HeroName.setText(hero.Base.select("tr").first().text());
        this.Jank.setText(name);
        this.SkillName.setText(hero.skill1.select("tr").first().text());
        this.SkillName1.setText(hero.skill2.select("tr").first().text());
        this.SkillName2.setText(hero.skill3.select("tr").first().text());
        this.SkillName3.setText(hero.skill4.select("tr").first().text());
        this.SkillName4.setText(hero.skill5.select("tr").first().text());
        this.SkillName5.setText(hero.skill6.select("tr").first().text());
        this.SkillName6.setText(hero.skill7.select("tr").first().text());

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LevelBox.getItems().addAll(1, 2, 3, 4, 5);
    }
}


