package com.example.hms.controller;

import com.example.hms.entity.PatientEntity;
import com.example.hms.exception.InvalidIdException;
import com.example.hms.service.PatientService;
import com.example.hms.serviceImple.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;
      @Autowired
        private PatientServiceImpl patientSI;
    //create
    @PostMapping("/post")
    public PatientEntity savePatient(@RequestBody PatientEntity patient) {
        return patientService.registerPatient(patient);
    }
//get
    @GetMapping("/get")
    public List<PatientEntity> getPatient(){
        return patientService.viewPatient();
    }

    @GetMapping("/getById")
    public PatientEntity getPatientById(Integer id) {
        return patientService.viewById(id);
    }


    @DeleteMapping("/delete/{id}")
    public String erasePatient(@PathVariable("id") Integer id) {
         patientService.deletePatient(id);
         return "deleted patient..!";

    }

    @PutMapping("{id}")
    public PatientEntity updatePatient(@PathVariable("id")int id, @RequestBody PatientEntity patientEntity){

     return patientSI.updatePatient(patientEntity,id);
    }



}
