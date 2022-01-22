package com.mahi.doctor.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest
public class AppointmentControllerTests {

        @Autowired
        private TestRestTemplate template;

}
