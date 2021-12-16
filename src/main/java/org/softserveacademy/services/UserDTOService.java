package org.softserveacademy.services;

public interface UserDTOService {

    UserDTO getUserById(Long id);

    Long createUser(UserDTO data);
}
