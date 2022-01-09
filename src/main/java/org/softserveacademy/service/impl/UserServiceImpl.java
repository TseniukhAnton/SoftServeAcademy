package org.softserveacademy.service.impl;

import org.softserveacademy.model.User;
import org.softserveacademy.repository.UserRepository;
import org.softserveacademy.repository.jdbc.JdbcUserRepositoryImpl;
import org.softserveacademy.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    public UserServiceImpl() {
        this.userRepository = new JdbcUserRepositoryImpl();
    }

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getById(int id) {
        return userRepository.getById(id);
    }

    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    public User deleteById(Integer id) {
        return userRepository.deleteById(id);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User save(String name, String email) {
        User user = new User(name, email);
        return userRepository.save(user);
    }

    public User update(Integer id, String newUserName, String newEmail) {
        User user;
        user = new User(id, newUserName, newEmail);

        return userRepository.update(user);
    }

}
