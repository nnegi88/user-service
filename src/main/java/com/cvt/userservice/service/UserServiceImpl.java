package com.cvt.userservice.service;

import com.cvt.userservice.dal.UserDal;
import com.cvt.userservice.model.User;
import com.cvt.userservice.model.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDal userDal;

    @Override
    public List<User> getAllUser() {
        return userDal.getAllUser();
    }

    @Override
    public User getUserById(String userId) throws UserNotFoundException {
        return userDal.getUserById(userId);
    }

    @Override
    public User saveUser(User user) {
        return userDal.saveUser(user);
    }

    @Override
    public User updateUserById(String userId, User user) {
        return userDal.updateUserById(userId, user);
    }

    @Override
    public User deleteUser(String userId) {
        return userDal.deleteUser(userId);
    }
}
