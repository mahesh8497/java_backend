package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class first {
    @RequestMapping("/req")
    public void asd(){
        System.out.println("Welcome");
    }
}
