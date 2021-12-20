package org.softserveacademy.service;

public interface UserDTOService {

    UserDTO getUserById(Long id);

    Long createUser(UserDTO data);
}
