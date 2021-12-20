package org.softserveacademy.service.impl;

import org.softserveacademy.repository.UserRepository;
import org.softserveacademy.repository.jdbc.JdbcUserRepositoryImpl;
import org.softserveacademy.service.UserService;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    public UserServiceImpl() {
        this.userRepository = new JdbcUserRepositoryImpl();
    }

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
