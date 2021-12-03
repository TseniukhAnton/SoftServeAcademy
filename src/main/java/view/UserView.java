package view;

import controller.UserController;
import model.User;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserView {
    private final Scanner scanner = new Scanner(new InputStreamReader(System.in));

    private final UserController userController = new UserController();

    public User getUserFromController() {
        System.out.println("Please enter User id to find it");
        Integer id = scanner.nextInt();
        System.out.println(userController.getUser(id));
        return userController.getUser(id);
    }

    public void deleteUserFromController() {
        System.out.println("Please enter User id");
        Integer id = scanner.nextInt();
        System.out.println(userController.getAllUsers());
        userController.deleteUser(id);
        System.out.println(userController.getAllUsers());
    }

    public User updateUserFromController() {
        System.out.println("Please enter User id, new name, new email");
        Integer id = scanner.nextInt();
        String name = scanner.next();
        String email = scanner.next();
        return userController.updateUser(id, name, email);
    }

    public User createUserFromController() {
        System.out.println("Please enter User id, name, email");
        Integer id = scanner.nextInt();
        String name = scanner.next();
        String email = scanner.next();
        return userController.createUser(id, name, email);
    }

    public List<User> getAllUsersFromController() {
        System.out.println(userController.getAllUsers());
        return userController.getAllUsers();
    }

}
