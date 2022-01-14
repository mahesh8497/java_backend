package com.ani.testing.controller;

import com.ani.testing.domain.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class CarControllerTest {
    @Autowired
    private TestRestTemplate template;

    @LocalServerPort
    private int port;

    @DisplayName("GET -Car-checking object is non null")
    @Test
    public void testGetMethod(){
//        var builder=new StringBuilder();
//        builder.append("http://")
//                .append("localhost")
//                .append(":")
//                .append("/car");
//        Car car = template.getForObject(
//                "http://localhost:8080/car",
//                Car.class
//        );
        String url = "http://" + "localhost" +":" + port +"/car";

        Car car = template.getForObject( // GET method
                url,
                Car.class
        );

        Assertions.assertNotNull(car);
    }
    @Test
    public void testGetStatusCode(){
        String url="http://"+"localhost"+":"+port+"/car";
        ResponseEntity<Car>entity=template.getForEntity(url,Car.class);
        Assertions.assertEquals(
                HttpStatus.OK,
                entity.getStatusCode()

        );

    }
    @DisplayName("POST - Car - Saving Car Object")
    @Test
    public void testPostMethod() {
        String url = "http://" + "localhost" +":" + port +"/car";
        var car = new Car();
        car.setCost(56.23);
        car.setId(10L);
        car.setModel("abc");
        car.setMfg(Date.valueOf(LocalDate.now()));
        var re = template.postForEntity(
                url,
                car,
                Car.class
        );
        Assertions.assertEquals(HttpStatus.CREATED, re.getStatusCode());
    }

}
