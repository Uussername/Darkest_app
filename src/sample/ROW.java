package sample;

import javafx.beans.property.SimpleStringProperty;

    public class ROW {
        private final SimpleStringProperty Catagory;
        private final SimpleStringProperty Level;


        public ROW(String first, String second) {
            this.Catagory = new SimpleStringProperty(first);
            this.Level = new SimpleStringProperty(second);

        }
        public String getCatagory() {
            return Catagory.get();
        }
        public void setCatagory(String Name) {
            Catagory.set(Name);
        }

        public String getLevel() {
            return Level.get();
        }
        public void setLevel(String Name) {
            Level.set(Name);
        }

    }


