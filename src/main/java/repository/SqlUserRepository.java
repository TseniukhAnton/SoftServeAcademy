package repository;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlUserRepository implements UserRepository {

    private static final String LOCATION = ".\\src\\main\\resources\\user.sql";

    private Connection connectToProjectDB(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "12345");
            System.out.println("Connection successful");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Exception" + e);
            }
        }

        return con;
    }

    private List<User> getUsers() {

        List<User> users = new ArrayList<>();
        try {
            Connection con = connectToProjectDB();
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
        }
        return users;
    }

    @Override
    public User getById(Integer id) {
        User user = null;
        try {
            Connection con = connectToProjectDB();
            PreparedStatement stmt = con.prepareStatement("SELECT* FROM user WHERE id=?");
            stmt.setInt(1, id);
            user = (User) stmt.executeQuery().getObject(1);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return user;
    }

    @Override
    public void deleteById(Integer id) {
        try {
            Connection con = connectToProjectDB();

            PreparedStatement stmt = con.prepareStatement("DELETE FROM user WHERE ID = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public User update(User user) {
        try {
            Connection con = connectToProjectDB();

            PreparedStatement stmt = con.prepareStatement("UPDATE user SET name=?, email=? WHERE id=?");
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setInt(3, user.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return user;
    }

    @Override
    public User save(User user) {
        try {
            Connection con = connectToProjectDB();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO user (name, email) VALUES(?, ?)");
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        return getUsers();
    }
}
