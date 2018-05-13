package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.Optional;

public class DBconnections {

    public static void main(Connection MyConn, String hero, String name, int level, int A, int B, int C, int D, int E, int F, int G) {
        // TODO Auto-generated method stub
        try {
            insert(MyConn, hero, name, level, A, B, C, D, E, F, G);
            select(MyConn, name);

            MyConn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Connection connect() throws SQLException {
        String DB_URL = "jdbc:mysql://db4free.net:3306/darkestdata";
        String USER = "uuussername";
        String PASSWORD = "rVYuw29!";
        Connection MyConn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        return MyConn;
    }

    public static void delete(Connection MyConn) throws SQLException {
        //Delete existing table
        Statement drop_stmt = MyConn.createStatement();
        String drop = "DROP TABLE Darkest_Data";
        drop_stmt.executeUpdate(drop);
    }

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

    public static void insert(Connection MyConn, String hero, String name, int level, int A, int B, int C, int D, int E, int F, int G) throws SQLException {
        Statement stmt = MyConn.createStatement();
        String insert = "INSERT INTO Darkest_Data " +
                "VALUES ('" + hero + "', '" + name + "', '" + level + "', '" + A + "', '" + B + "', '" + C + "', '" + D + "', '" + E + "', '" + F + "', '" + G + "')";
        stmt.executeUpdate(insert);
    }

    public static void select(Connection MyConn, String name) throws SQLException {
        Statement stmt = MyConn.createStatement();
        String select = "SELECT Hero, Name, Skill1, Skill2, Skill3,  Skill4, Skill5,  Skill6,  Skill7" +
                " FROM Darkest_Data WHERE Name = '" + name + "'";
        ResultSet rs = stmt.executeQuery(select);

        while (rs.next()) {
            int id = rs.getInt("Skill1");
            String Hero = rs.getString("Hero");
            int Age = rs.getInt("Skill2");

        }
        rs.close();
    }

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