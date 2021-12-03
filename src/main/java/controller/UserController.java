package controller;

import model.User;
import repository.SqlUserRepository;
import repository.UserRepository;

import java.util.List;

public class UserController {

    private final UserRepository repo = new SqlUserRepository();

    public User getUser(Integer id) {
        return repo.getById(id);
    }

    public void deleteUser(Integer id) {
        repo.deleteById(id);
    }

    public User updateUser(Integer id, String name, String email) {
        User user = new User(id, name, email);
        return repo.update(user);
    }

    public User createUser(Integer id, String name, String email) {
        User user = new User(id, name, email);
        return repo.save(user);
    }

    public List<User> getAllUsers() {
        return repo.getAll();
    }

}
