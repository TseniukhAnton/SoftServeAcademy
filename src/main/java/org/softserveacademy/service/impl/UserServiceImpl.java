package org.softserveacademy.service.impl;

import org.softserveacademy.model.User;
import org.softserveacademy.repository.jdbc.JdbcUserRepositoryImpl;
import org.softserveacademy.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl userServiceImpl;

    private UserServiceImpl(){

    }

    public static synchronized UserServiceImpl getInstance(){
        if (userServiceImpl == null){
            userServiceImpl = new UserServiceImpl();
        }
        return userServiceImpl;
    }

    public User getById(int id) {
        return JdbcUserRepositoryImpl.getInstance().getById(id);
    }

    public User getByEmail(String email) {
        return JdbcUserRepositoryImpl.getInstance().getByEmail(email);
    }

    public User deleteById(Integer id) {
        return JdbcUserRepositoryImpl.getInstance().deleteById(id);
    }

    public List<User> getAll() {
        return JdbcUserRepositoryImpl.getInstance().getAll();
    }

    public User save(User user) {
        return JdbcUserRepositoryImpl.getInstance().save(user);
    }

    public User update(User user) {
        return JdbcUserRepositoryImpl.getInstance().update(user);
    }

}
