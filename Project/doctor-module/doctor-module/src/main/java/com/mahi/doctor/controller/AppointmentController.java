package com.mahi.doctor.controller;


import com.mahi.doctor.domain.Appointment;
import com.mahi.doctor.dto.AppResponse;
import com.mahi.doctor.dto.AppointmentDto;
import com.mahi.doctor.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RequestMapping("/appointment")
@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @PostMapping("/createAppointment")
    public ResponseEntity<AppResponse<AppointmentDto>> createAppointment(@RequestBody AppointmentDto dto) {

        var svObj = service.createAppointment(dto);

        var response = new AppResponse<AppointmentDto>();
        response.setStatus("success");
        response.setMessage("Appointment saved successfully");
        response.setBody(svObj);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/updateAppoint")
    public ResponseEntity<AppResponse<String>> updateAppointment(@RequestBody AppointmentDto dto) {
        String stat = service.updateAppointment(dto.getId(), dto.getAppointmentDate());
        var response = new AppResponse<String>();
        response.setMessage("Appointment is update");
        response.setStatus("success");
        response.setBody(stat);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

        @PutMapping("/cancelAppointment")
        public ResponseEntity<AppResponse<String>> cancelAppointment(@RequestBody AppointmentDto dto) {
            String stat = service.cancelAppointment(dto.getId());
            var response = new AppResponse<String>();
            response.setMessage("Appointment is removed");
            response.setStatus("success");
            response.setBody(stat);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }

        @GetMapping("/serchCanceledAppointment")
        public ResponseEntity<AppResponse<String>> cancelAppointment() {

            List<Appointment> list=service.serchCanceledAppointment();

            var response = new AppResponse<String>();
            response.setStatus("success");
            response.setMessage("All cancelled appointment");
            response.setList(list);
            return  new ResponseEntity<>(response,HttpStatus.ACCEPTED);
        }

        @GetMapping("/searchAppointmentsByDoctorName")
        public ResponseEntity<AppResponse<String>> searchAppointmentsByDoctorName(@RequestBody AppointmentDto dto) {

        List<Appointment> list=service.searchAppointmentsByDoctorName(dto.getDoctorName());

            var response =new AppResponse<String>();
        response.setMessage("success");
        response.setStatus("Appointment by Doctor Name");
            response.setList(list);
            return new ResponseEntity(response,HttpStatus.ACCEPTED);

        }


        }
