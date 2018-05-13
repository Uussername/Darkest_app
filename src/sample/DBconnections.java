package sample;

import java.sql.*;

public class DBconnections {

        public static void main(String hero, String name, int level, int A, int B, int C, int D, int E, int F, int G)
        {
            // TODO Auto-generated method stub
            try
            {
                String DB_URL = "jdbc:mysql://db4free.net:3306/darkestdata";
                String USER = "uuussername";
                String PASSWORD = "rVYuw29!";
                Connection MyConn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                System.out.println("Connected");

                delete(MyConn);
                create(MyConn);
                insert(MyConn, hero, name, level, A, B, C, D, E, F, G);
                select(MyConn, name);

                MyConn.close();
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public static void delete(Connection MyConn) throws SQLException
        {
            //Delete existing table
            Statement drop_stmt = MyConn.createStatement();
            String drop = "DROP TABLE Darkest_Data";
            drop_stmt.executeUpdate(drop);
            System.out.println("Deleted table in given database");
        }

        public static void create(Connection MyConn) throws SQLException
        {
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
            System.out.println("Created table in given database");
        }

        public static void insert(Connection MyConn,String hero, String name, int level, int A, int B, int C, int D, int E, int F, int G) throws SQLException
        {
            Statement stmt = MyConn.createStatement();
            String insert = "INSERT INTO Darkest_Data " +
                    "VALUES ('"+hero+"', '"+name+"', '"+ level +"', '"+A+"', '"+B+"', '"+C+"', '"+D+"', '"+E+"', '"+F+"', '"+G+"')";
            stmt.executeUpdate(insert);
            System.out.println("Inserted records to given database");
        }

        public static void select(Connection MyConn, String name) throws SQLException
        {
            Statement stmt = MyConn.createStatement();
            String select = "SELECT Hero, Name, Skill1, Skill2, Skill3,  Skill4, Skill5,  Skill6,  Skill7" +
                    " FROM Darkest_Data WHERE Name = '"+ name +"'";
            ResultSet rs = stmt.executeQuery(select);

            while(rs.next())
            {
                int id = rs.getInt("Skill1");
                String Hero = rs.getString("Hero");
                int Age = rs.getInt("Skill2");

                System.out.print("ID: " + id);
                System.out.print(", Name: " + Hero);
                System.out.print(", Age: " + Age + "\n");
            }
            rs.close();
        }
    }