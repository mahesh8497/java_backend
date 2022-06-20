package com.mah.casestudy.Service;


import java.util.List;

import com.mah.casestudy.model.User;
import com.mah.casestudy.repository.DataRepository;
import com.mah.casestudy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CheckProfile {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DataRepository dataRepository;

    public List<User> getDetails(String username)
    {
        return userRepository.getDetails(username);
    }

    public List<User> getAll(String role) {

        return dataRepository.getAll(role);
    }
}