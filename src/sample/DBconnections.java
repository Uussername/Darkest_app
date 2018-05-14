package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Class for all JDBC functions including connecting, table creation and deletion, and data selecting
 */
public class DBconnections {
    /**
     * Connects to database darkestdata
     *
     * @return database connection
     *
     * @throws SQLException exception for unable to connect
     */
    public static Connection connect() throws SQLException {
        String DB_URL = "jdbc:mysql://db4free.net:3306/darkestdata";
        String USER = "uuussername";
        String PASSWORD = "rVYuw29!";
        Connection MyConn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        return MyConn;
    }

    /**
     * deletes table Darkest_Data, used to reset the table for testing purposes
     *
     * @param MyConn database connection
     * @throws SQLException standard SQL error catch
     */
    public static void delete(Connection MyConn) throws SQLException {
        //Delete existing table
        Statement drop_stmt = MyConn.createStatement();
        String drop = "DROP TABLE Darkest_Data";
        drop_stmt.executeUpdate(drop);
    }

    /**
     * Creates table Darkest_Data, table has 10 columns, hero class, name, level, and 7 skills, name being the Primary key
     *
     * @param MyConn Database connection
     * @throws SQLException standard SQL error catch
     */
    public static void create(Connection MyConn) throws SQLException {
        //Create new table
        Statement stmt = MyConn.createStatement();
        String create = "CREATE TABLE Darkest_Data" +
                " (Hero VARCHAR(255), " +
                " Name VARCHAR(255), " +
                " Level INTEGER not NULL, " +
                " Skill1 INTEGER not NULL, " +
                " Skill2 INTEGER not NULL," +
                " Skill3 INTEGER not NULL," +
                " Skill4 INTEGER not NULL," +
                " Skill5 INTEGER not NULL," +
                " Skill6 INTEGER not NULL," +
                " Skill7 INTEGER not NULL," +
                "PRIMARY KEY ( Name ))";
        stmt.executeUpdate(create);
    }

    /**
     * Appends table Darkest_Data adding a new hero row
     *
     * @param MyConn DataBase Connection
     * @param hero elements of webpage
     * @param name name of hero class
     * @param level resolve level of hero, value in combobox
     * @param A if Skill check box was checked
     * @param B if Skill1 check box was checked
     * @param C if Skill2 check box was checked
     * @param D if Skill3 check box was checked
     * @param E if Skill4 check box was checked
     * @param F if Skill5 check box was checked
     * @param G if Skill6 check box was checked
     * @throws SQLException
     */
    public static void insert(Connection MyConn, String hero, String name, int level, int A, int B, int C, int D, int E, int F, int G) throws SQLException {
        Statement stmt = MyConn.createStatement();
        String insert = "INSERT INTO Darkest_Data " +
                "VALUES ('" + hero + "', '" + name + "', '" + level + "', '" + A + "', '" + B + "', '" + C + "', '" + D + "', '" + E + "', '" + F + "', '" + G + "')";
        stmt.executeUpdate(insert);
    }

    /**
     * searches the database for a hero and loads the values of their skills and level into an arraylist to be referenced
     * @param MyConn database connection
     * @param name hero's name
     * @throws SQLException
     */
    public static ArrayList<Integer> select(Connection MyConn, String name) throws SQLException {
        Statement stmt = MyConn.createStatement();
        String select = "SELECT Hero, Name, Level, Skill1, Skill2, Skill3,  Skill4, Skill5,  Skill6,  Skill7" +
                " FROM Darkest_Data WHERE Name = '" + name + "'";
        ResultSet rs = stmt.executeQuery(select);
        ArrayList<Integer> skills = new ArrayList<>();
        while (rs.next()) {
            String Hero = rs.getString("Hero");
            int Level = rs.getInt("Level");
            int A = rs.getInt("Skill1");
            int B = rs.getInt("Skill2");
            int C = rs.getInt("Skill3");
            int D = rs.getInt("Skill4");
            int E = rs.getInt("Skill5");
            int F = rs.getInt("Skill6");
            int G = rs.getInt("Skill7");
            skills.add(Level);
            skills.add(A);
            skills.add(B);
            skills.add(C);
            skills.add(D);
            skills.add(E);
            skills.add(F);
            skills.add(G);
        }
        rs.close();
        return skills;
    }

    /**
     * reads the database grabbing all rows and only returning the hero's class and name
     * @param MyConn
     * @return
     * @throws SQLException
     */
    public static ObservableList<ROW> read(Connection MyConn) throws SQLException {
        Statement stmt = MyConn.createStatement();
        String select = "SELECT Hero, Name, Skill1, Skill2, Skill3,  Skill4, Skill5,  Skill6,  Skill7" +
                " FROM Darkest_Data";
        ResultSet rs = stmt.executeQuery(select);

        final ObservableList<ROW> data = FXCollections.observableArrayList();
        while (rs.next()) {
            String Hero = rs.getString("Hero");
            String name = rs.getString("Name");
            ROW item = new ROW(Hero, name);
            data.add(item);
        }
        rs.close();
        return data;
    }

    /**
     * Searches the database to find any duplicate name entries
     * @param MyConn database connection
     * @param name hero's name
     *
     * @return if the search found a duplicate or not
     * @throws SQLException
     */
    public static Boolean UniqueSelect(Connection MyConn, Optional<String> name) throws SQLException {
        Statement stmt = MyConn.createStatement();
        String realName = name.toString().substring(9, name.toString().length()-1);
        boolean checker = true;
        String select = "SELECT Name FROM Darkest_Data WHERE Name = '" + realName + "'";
        ResultSet rs = stmt.executeQuery(select);

        while (rs.next()) {
            String Hero = rs.getString("Name");
            if( Hero.toUpperCase().equals(realName.toUpperCase())){
                checker = false;
            }
        }
        rs.close();
        return checker;
    }
}