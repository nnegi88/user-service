package com.cvt.userservice.service;

import com.cvt.userservice.model.User;
import com.cvt.userservice.model.UserNotFoundException;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getUserById(String userId) throws UserNotFoundException;
    void saveUser(User user);
    void updateUserById(String userId, User user);
    void deleteUser(String userId);
}
