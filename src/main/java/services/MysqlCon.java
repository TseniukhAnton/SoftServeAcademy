package services;

import java.sql.*;

public class MysqlCon {
    public static void main(String[] args) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "12345");
            System.out.println("Connection successful");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from user");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Exception" + e);
            }
        }
    }
}
