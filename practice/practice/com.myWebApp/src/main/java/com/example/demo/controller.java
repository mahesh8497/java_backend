package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;

public class controller {

    @GetMapping("")
    public String myHomePage(){
        System.out.println("main controller");
        return "index";
    }
}
