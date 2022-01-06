package org.softserveacademy.repository.jdbc;

import org.softserveacademy.model.User;
import org.softserveacademy.repository.UserRepository;
import org.softserveacademy.util.JdbcUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//@Slf4j
public class JdbcUserRepositoryImpl implements UserRepository {

    private static final String GET_USERS_QUERY = "SELECT * FROM user";
    private static final String GET_USER_QUERY = "SELECT* FROM user WHERE id=?";
    private static final String GET_USER_EMAIL_QUERY = "SELECT* FROM user WHERE EMAIL=?";
    private static final String DELETE_USER_QUERY = "DELETE FROM user WHERE ID = ?";
    private static final String UPDATE_USER_QUERY = "UPDATE user SET name=?, email=? WHERE id=?";
    private static final String CREATE_USER_QUERY = "INSERT INTO user (name, email) VALUES(?, ?)";
    private final JdbcUtils jdbcUtils = new JdbcUtils();


    @Override
    public User getById(Integer id) {
        User user = null;
        try (PreparedStatement stmt = jdbcUtils.getPreparedStatement(GET_USER_QUERY)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int idRes = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                user = User.builder()
                        .id(idRes)
                        .name(name)
                        .email(email)
                        .build();
            }
        } catch (Exception e) {
         //   log.error(e.getMessage());
        }
        return user;
    }

    @Override
    public User getByEmail(String email) {
        User user = null;
        try (PreparedStatement stmt = jdbcUtils.getPreparedStatement(GET_USER_EMAIL_QUERY)) {
            stmt.setString(3, email);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String emailRes = rs.getString(3);
                user = User.builder()
                        .id(id)
                        .name(name)
                        .email(emailRes)
                        .build();
            }
        } catch (Exception e) {
            //   log.error(e.getMessage());
        }
        return user;
    }

    @Override
    public User deleteById(Integer id) {
        try (PreparedStatement stmt = jdbcUtils.getPreparedStatement(DELETE_USER_QUERY)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
          //  log.error(e.getMessage());
        }
        return getById(id);
    }

    @Override
    public User update(User user) {
        try (PreparedStatement stmt = jdbcUtils.getPreparedStatement(UPDATE_USER_QUERY)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setInt(3, user.getId());
            stmt.execute();
        } catch (Exception e) {
         //   log.error(e.getMessage());
        }
        return user;
    }

    @Override
    public User save(User user) {
        try (PreparedStatement stmt = jdbcUtils.getPreparedStatement(CREATE_USER_QUERY)) {
            stmt.getGeneratedKeys();
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.execute();
        } catch (Exception e) {
           // log.error(e.getMessage());
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (PreparedStatement stmt = jdbcUtils.getPreparedStatement(GET_USERS_QUERY)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                users.add(User.builder()
                        .id(id)
                        .name(name)
                        .email(email)
                        .build());
               // log.info("id: {}, name: {}, author: {}", id, name, email);
            }
        } catch (Exception e) {
           // log.error(e.getMessage());
        }
        return users;
    }
}
