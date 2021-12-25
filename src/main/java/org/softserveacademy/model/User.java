package org.softserveacademy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Statement;

@AllArgsConstructor
@Data
@Builder
public class User {
    private Integer id;
    private String name;
    private String email;


    public User(String name, String email) {
        this.id = Statement.RETURN_GENERATED_KEYS;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
