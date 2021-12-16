package org.softserveacademy.controller;

import org.softserveacademy.model.User;
import org.softserveacademy.repository.jdbc.JdbcUserRepositoryImpl;
import org.softserveacademy.repository.UserRepository;

import java.util.List;

public class UserController {

    private final UserRepository repo = new JdbcUserRepositoryImpl();

    public User getUser(Integer id) {
        return repo.getById(id);
    }

    public User deleteUser(Integer id) {
        repo.deleteById(id);
        return repo.getById(id);
    }

    public User updateUser(Integer id, String name, String email) {
        User user;
        user = new User(id, name, email);
        return repo.update(user);
    }

    public User createUser( String name, String email) {
        User user = new User(name, email);
        return repo.save(user);
    }

    public List<User> getAllUsers() {
        return repo.getAll();
    }

}
