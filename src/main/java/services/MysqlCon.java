package services;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MysqlCon {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "12345");
            System.out.println("Connection successful");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT* FROM user");
            while (rs.next()) ;
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            con.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
