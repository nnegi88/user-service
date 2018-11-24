package com.cvt.userservice.dal;

import com.cvt.userservice.model.User;
import com.cvt.userservice.model.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDalImpl implements UserDal {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<User> getAllUser() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public User getUserById(String userId) throws UserNotFoundException {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(userId));
        User user = mongoTemplate.findOne(query, User.class);
        if (user==null) throw new UserNotFoundException(userId);
        return user;
    }

    @Override
    public User saveUser(User user) {
        return mongoTemplate.save(user);
    }

    @Override
    public User updateUserById(String userId, User user) {
        User oldUser = getUserById(userId);
        oldUser = user;
        return saveUser(user);
    }

    @Override
    public User deleteUser(String userId) {
        User user = getUserById(userId);
        mongoTemplate.remove(user);
        return user;
    }
}