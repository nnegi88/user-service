package com.cvt.userservice.dal;

import com.cvt.userservice.model.User;
import com.cvt.userservice.model.UserNotFoundException;

import java.util.List;

public interface UserDal {
    List<User> getAllUser();
    User getUserById(String userId) throws UserNotFoundException;
    User saveUser(User user);
    User updateUserById(String userId, User user);
    User deleteUser(String userId);
}
