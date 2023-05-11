package com.example.hms.controller;


import com.example.hms.dao.AppResponse;
import com.example.hms.dao.AppointmentDto;
import com.example.hms.entity.AppointmentEntity;
import com.example.hms.exception.InvalidIdException;
import com.example.hms.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;


@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/createAppointment")
    public ResponseEntity<AppResponse<AppointmentDto>> createAppointment(@RequestBody AppointmentDto dto) {


        var response = new AppResponse<AppointmentDto>();
        if (dto != null && dto.getDoctorName() != null &&
                dto.getPatient_Name() != null && dto.getAppointmentDate() != null) {
            var svObj = appointmentService.createAppointment(dto);


            response.setStatus("success");
            response.setMessage("Appointment saved successfully");
            response.setBody(svObj);

            return ResponseEntity.ok(response);
        } else {
            response.setMessage("fail");
            response.setStatus("Please fill all info");

            return ResponseEntity.ok(response);
        }
    }


    @PutMapping("/updateAppoint")
    public ResponseEntity<AppResponse<String>> updateAppointment(@RequestBody AppointmentDto dto) {
        try {
            AppointmentDto stat = appointmentService.updateAppointment(dto);
            var response = new AppResponse<String>();
            response.setMessage("Appointment is updated");
            response.setStatus("success");
            response.setBody(String.valueOf(stat));
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (InvalidIdException e) {
            var response = new AppResponse<AppointmentDto>();
            response.setStatus("fail");
            response.setMessage(e.getMessage());
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AppResponse<String>> deleteAppointmentById(@PathVariable("id") Integer id) {

        try {
            String stat = appointmentService.deleteAppointment(id);
            var response = new AppResponse<String>();
            response.setMessage("Appointment is removed");
            response.setStatus("success");

            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (InvalidIdException e) {
            var response = new AppResponse<AppointmentDto>();
            response.setStatus("fail");
            response.setMessage(e.getMessage());
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/showAppointment")
    List<AppointmentEntity>findAllAppointment(){
        return appointmentService.findAllApp();
    }
}
