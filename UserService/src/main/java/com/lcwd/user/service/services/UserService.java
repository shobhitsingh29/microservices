package com.lcwd.user.service.services;

import com.lcwd.user.service.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> getAllUsers();

    User getUser(String userId);

    User updateUser(User user, String userId);

    User deleteUser(String userId);

}
