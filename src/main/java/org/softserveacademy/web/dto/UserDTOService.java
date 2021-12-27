package org.softserveacademy.web.dto;

public interface UserDTOService {

    UserDTO getUserById(Long id);

    Long createUser(UserDTO data);
}
