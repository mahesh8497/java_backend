package com.mah.casestudy.controller;

import java.util.List;

import com.mah.casestudy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;


    @GetMapping(path="/register")
    public String showRegister() {
        return "register";
    }

    @GetMapping(path="/index")
    public String showIndex() {
        return "index";
    }

    @GetMapping(path="/home")
    public String showHome() {
        return "home";
    }

}