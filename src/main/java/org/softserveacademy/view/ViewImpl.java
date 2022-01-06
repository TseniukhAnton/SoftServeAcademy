package org.softserveacademy.view;

import java.io.InputStreamReader;
import java.util.Scanner;

public class ViewImpl {
    private final Scanner scanner = new Scanner(new InputStreamReader(System.in));

    private final UserView userView = new UserView();

    public void start() {
        System.out.println("What would you like to do? Create, Read, Update, Delete or ShowAll?");
        String sc = scanner.next();
        switch (sc) {
            case "Create" -> {
                userView.createUserFromController();
                System.out.println("New User was created");
                userView.getUserFromController();
            }
            case "Read" -> userView.getUserFromController();
            case "Update" -> {
                userView.updateUserFromController();
                System.out.println("User was updated");
                userView.getUserFromController();
            }
            case "Delete" -> {
                userView.getAllUsersFromController();
                userView.deleteUserFromController();
                System.out.println("User was deleted");
                userView.getAllUsersFromController();
            }
            case "ShowAll" -> userView.getAllUsersFromController();
            default -> System.out.println("Wrong command!");
        }
    }
}
