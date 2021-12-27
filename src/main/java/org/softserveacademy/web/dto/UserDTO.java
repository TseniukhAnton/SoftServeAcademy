package org.softserveacademy.web.dto;

import java.sql.Statement;

public class UserDTO {
    private final Integer id;
    private String name;
    private String email;

    public UserDTO(String name, String email) {
        this.id = Statement.RETURN_GENERATED_KEYS;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
