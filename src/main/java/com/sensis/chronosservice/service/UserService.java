package com.sensis.chronosservice.service;


import com.sensis.chronosservice.model.User;
import com.sensis.chronosservice.model.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(UserDTO user);

    void delete(Long id);

    List<User> findAll();

    Optional<User> findById(Long id);

    User findByUsername(String username);

    User update(Long id, User user);
}
