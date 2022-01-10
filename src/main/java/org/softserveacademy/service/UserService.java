package org.softserveacademy.service;

import org.softserveacademy.model.User;

import java.util.List;

public interface UserService {
    User getById(int id);

    User getByEmail(String email);

    User deleteById(Integer id);

    List<User> getAll();

    User save(User user);

    User update(User user);
}
