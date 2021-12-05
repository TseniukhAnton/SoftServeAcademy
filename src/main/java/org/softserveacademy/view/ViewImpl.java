package org.softserveacademy.view;

import java.io.InputStreamReader;
import java.util.Scanner;

public class ViewImpl {
    private final Scanner scanner = new Scanner(new InputStreamReader(System.in));

    private final UserView userView = new UserView();

    public void start() {
        System.out.println("What would you like to do? Create, Read, Update or Delete?");
        String sc = scanner.next();
        if (sc.equals("Create")) {
            userView.createUserFromController();
            System.out.println("New User was created");
            userView.getUserFromController();
        } else {
            System.out.println("Wrong command!");
        }

        if (sc.equals("Read")) {
            userView.getUserFromController();
        } else {
            System.out.println("Wrong command!");
        }

        if (sc.equals("Update")) {
            userView.updateUserFromController();
            System.out.println("User was updated");
            userView.getUserFromController();
        } else {
            System.out.println("Wrong command!");
        }

        if (sc.equals("Delete")) {
            userView.getAllUsersFromController();
            userView.deleteUserFromController();
            System.out.println("User was deleted");
            userView.getAllUsersFromController();
        } else {
            System.out.println("Wrong command!");
        }
    }
}
