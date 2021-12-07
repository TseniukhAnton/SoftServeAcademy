package org.softserveacademy.repository.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.softserveacademy.model.User;
import org.softserveacademy.repository.UserRepository;
import org.softserveacademy.util.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class JdbcUserRepositoryImpl implements UserRepository {

    private static final String GET_USERS_QUERY = "select * from user";

    @Override
    public User getById(Integer id) {
        User user = null;
        try (PreparedStatement stmt = JdbcUtils.getPreparedStatement("SELECT* FROM user WHERE id=?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
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
            log.error(e.getMessage());
        }
        return user;
    }

    @Override
    public void deleteById(Integer id) {
        try (PreparedStatement stmt = JdbcUtils.getPreparedStatement("DELETE FROM user WHERE ID = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public User update(User user) {
        try (PreparedStatement stmt = JdbcUtils.getPreparedStatement("UPDATE user SET name=?, email=? WHERE id=?")) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setInt(3, user.getId());
            stmt.execute();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return user;
    }

    @Override
    public User save(User user) {
        try (PreparedStatement stmt = JdbcUtils.getPreparedStatement("INSERT INTO user (name, email) VALUES(?, ?)")) {
            stmt.getGeneratedKeys();
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.execute();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (PreparedStatement stmt = JdbcUtils.getPreparedStatement(GET_USERS_QUERY)) {
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
                log.info("id: {}, name: {}, author: {}", id, name, email);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return users;
    }
}
