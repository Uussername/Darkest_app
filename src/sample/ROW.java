package sample;

import javafx.beans.property.SimpleStringProperty;
/**
 * class used to format data into tables
 * setting data for easy table creation
 */
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


