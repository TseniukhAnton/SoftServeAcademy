package org.softserveacademy.web.dto;

public interface UserDTOService {

    UserDTO getUserByEmail(String email);

    Long createUser(UserDTO data);
}
