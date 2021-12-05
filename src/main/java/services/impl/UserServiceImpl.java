package services.impl;

import repository.UserRepository;
import repository.jdbc.JdbcUserRepositoryImpl;
import services.UserService;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    public UserServiceImpl() {
        this.userRepository = new JdbcUserRepositoryImpl();
    }

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
