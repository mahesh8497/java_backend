package com.springBootProject.springbootproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class HomeController {
    @RequestMapping("/")
    public String home(){
        return "Hello world";
    }

}
