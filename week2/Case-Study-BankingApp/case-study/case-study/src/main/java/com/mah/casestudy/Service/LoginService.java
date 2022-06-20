package com.mah.casestudy.Service;


import com.mah.casestudy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;



    public boolean isValid(String username, String password) {

        return userRepository.search(username,password);

    }
}
