package org.softserveacademy.web.dto;

public class UserDTO implements UserDTOService{
    private String name;
    private String email;

    public UserDTO(String name, String email) {
        this.name = name;
        this.email = email;
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

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        return null;
    }

    @Override
    public Long createUser(UserDTO data) {
        return null;
    }
}
