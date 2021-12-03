package repository;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlUserRepository implements UserRepository {

    private static final String LOCATION = ".\\src\\main\\resources\\user.sql";

    private List<User> getUsers() {
        Connection con = null;
        List<User> users = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "12345");
            System.out.println("Connection successful");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from user");

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                users.add(new User(id, name, email));
                System.out.printf("id: %d, name: %s, author: %s %n", id, name, email);
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
        return users;
    }

    @Override
    public User getById(Integer id) {
        return getUsers().stream().filter(user -> user.getId().equals(id)).findFirst().get();
    }

    @Override
    public void deleteById(Integer id) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "12345");
            System.out.println("Connection successful");

            PreparedStatement stmt = con.prepareStatement("DELETE FROM user WHERE ID = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
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

    @Override
    public User update(User user) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "12345");
            System.out.println("Connection successful");

            PreparedStatement stmt = con.prepareStatement("UPDATE user SET name=?, email=? WHERE id=?");
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setInt(3, user.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Exception" + e);
            }
        }
        return user;
    }

    @Override
    public User save(User user) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "12345");
            System.out.println("Connection successful");

            PreparedStatement stmt = con.prepareStatement("INSERT INTO user (name, email) VALUES(?, ?)");
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Exception" + e);
            }
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        return getUsers();
    }
}
