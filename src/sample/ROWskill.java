package sample;

import javafx.beans.property.SimpleStringProperty;

public class ROWskill {

    private final SimpleStringProperty First;
    private final SimpleStringProperty Second;
    private final SimpleStringProperty Third;
    private final SimpleStringProperty Fourth;
    private final SimpleStringProperty Fifth;
    private final SimpleStringProperty Sixth;
    private final SimpleStringProperty Seventh;
    private final SimpleStringProperty Eighth;

    public ROWskill(String first, String second, String third, String fourth, String fifth, String sixth,String seventh, String eighth) {
        this.First = new SimpleStringProperty(first);
        this.Second = new SimpleStringProperty(second);
        this.Third = new SimpleStringProperty(third);
        this.Fourth = new SimpleStringProperty(fourth);
        this.Fifth = new SimpleStringProperty(fifth);
        this.Sixth = new SimpleStringProperty(sixth);
        this.Eighth = new SimpleStringProperty(eighth);
        this.Seventh = new SimpleStringProperty(seventh);
    }
    public ROWskill(String first, String second, String third, String fourth) {
        this.First = new SimpleStringProperty(first);
        this.Second = new SimpleStringProperty(second);
        this.Third = new SimpleStringProperty(third);
        this.Fourth = new SimpleStringProperty(fourth);
        this.Fifth = new SimpleStringProperty("");
        this.Sixth = new SimpleStringProperty("");
        this.Eighth = new SimpleStringProperty("");
        this.Seventh = new SimpleStringProperty("");
    }
    public ROWskill(String first, String second, String third, String fourth, String fifth, String sixth) {
        this.First = new SimpleStringProperty(first);
        this.Second = new SimpleStringProperty(second);
        this.Third = new SimpleStringProperty(third);
        this.Fourth = new SimpleStringProperty(fourth);
        this.Fifth = new SimpleStringProperty(fifth);
        this.Sixth = new SimpleStringProperty(sixth);
        this.Eighth = new SimpleStringProperty("");
        this.Seventh = new SimpleStringProperty("");
    }
    public String getFirst() {
        return First.get();
    }
    public void setFirst(String Name) {
        First.set(Name);
    }

    public String getSecond() {
        return Second.get();
    }
    public void setSecond(String Name) {
        Second.set(Name);
    }
    public String getThird() {
        return Third.get();
    }
    public void setThird(String Name) {
        Third.set(Name);
    }
    public String getFourth() {
        return Fourth.get();
    }
    public void setFourth(String Name) {
        Fourth.set(Name);
    }
    public String getFifth() {
        return Fifth.get();
    }
    public void setFifth(String Name) {
        Fifth.set(Name);
    }
    public String getSixth() {
        return Sixth.get();
    }
    public void setSixth(String Name) {
        Sixth.set(Name);
    }
    public String getSeventh() {
        return Seventh.get();
    }
    public void setSeventh(String Name) {
        Seventh.set(Name);
    }
    public String getEighth() {
        return Eighth.get();
    }
    public void setEighth(String Name) {
        Eighth.set(Name);
    }

}
