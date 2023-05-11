package com.User.service.Impl;

import com.User.service.entity.User;
import com.User.service.exception.ResourceNotFound;
import com.User.service.repository.User_Repository;
import com.User.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class userServiceImpl implements UserService {
    @Autowired
    private User_Repository user_repository;

    @Override
    public User saveUser(User user) {
        String randomUserId= UUID.randomUUID().toString();//this is used to generate unique Id
        user.setUserId(randomUserId);
        return   user_repository.save(user);

    }

    @Override
    public List<User> getAllUser() {
        return user_repository.findAll();
    }

    @Override
    public User getUser(String userId) {
        return user_repository.findById(userId).orElseThrow(()-> new ResourceNotFound("User with given Id"+userId));
    }
}
