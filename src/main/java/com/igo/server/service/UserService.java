package com.igo.server.service;

import com.igo.server.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    User updateUser(User user);

    void deleteUser(Long userId);

    User findByUsername(String username);

    User findUserById(Long id);

    List<User> findAllUsers();

    Long numberOfUsers();
}
