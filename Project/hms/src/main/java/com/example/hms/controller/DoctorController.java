package com.example.hms.controller;

import com.example.hms.entity.DoctorEntity;
import com.example.hms.service.DoctorService;
import com.example.hms.serviceImple.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/d")
public class DoctorController {
    @Autowired
    private DoctorServiceImpl doctorServiceImpl;

    @Autowired
    private DoctorService service;


    @PostMapping("/add")
    public DoctorEntity addDoctor(@RequestBody DoctorEntity doctor) {
        return doctorServiceImpl.saveDoctor(doctor);
    }

    @GetMapping("/get")
    public List<DoctorEntity> getDoctorList(){
        return doctorServiceImpl.viewDoctors();
    }


//    @PutMapping("{id}")
//    public DoctorEntity updateDoctor(@PathVariable("id") int id,@RequestBody DoctorEntity doctorEntity){
//        return doctorServiceImpl.updateDoctor(doctorEntity,id);
//    }

}