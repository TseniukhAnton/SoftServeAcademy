package org.softserveacademy.model;

import org.junit.Test;

import static org.junit.Assert.*;

import org.softserveacademy.model.User;

public class UserTest {
    @Test
    public void createUserIsPossible() {
        User user = new User(1, "Yurii", "yura@gmail.com");
        assertNotNull(user);
    }
}
