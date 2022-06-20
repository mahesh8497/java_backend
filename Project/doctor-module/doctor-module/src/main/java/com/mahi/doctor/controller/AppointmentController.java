package com.mahi.doctor.controller;

import com.mahi.doctor.domain.Appointment;
import com.mahi.doctor.dto.AppResponse;
import com.mahi.doctor.dto.AppointmentDto;
import com.mahi.doctor.exception.InvalidDoctorName;
import com.mahi.doctor.exception.InvalidIdException;
import com.mahi.doctor.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/appointment")
@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @PostMapping("/createAppointment")
    public ResponseEntity<AppResponse<AppointmentDto>> createAppointment(@RequestBody AppointmentDto dto) {

        var response = new AppResponse<AppointmentDto>();
        if (dto != null && dto.getPlaced() != null && dto.getDoctorName() != null && dto.getAppointmentStatus() != null
                && dto.getDoctorName() != null && dto.getAppointmentDate() != null) {
            var svObj = service.createAppointment(dto);


            response.setStatus("success");
            response.setMessage("Appointment saved successfully");
            response.setBody(svObj);

            return ResponseEntity.ok(response);
        } else {
            response.setMessage("fail");
            response.setStatus("Pleas fill all info");

            return ResponseEntity.ok(response);
        }
    }
    @PutMapping("/updateAppoint")
    public ResponseEntity<AppResponse<String>> updateAppointment(@RequestBody AppointmentDto dto) {
        try {
            AppointmentDto stat = service.updateAppointment(dto);
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

    @PutMapping("/cancelAppointment")
    public ResponseEntity<AppResponse<String>> cancelAppointment(@RequestBody AppointmentDto dto) {
        try {
            String stat = service.cancelAppointment(dto.getId());
            var response = new AppResponse<String>();
            response.setMessage("Appointment is removed");
            response.setStatus("success");
            response.setBody(stat);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }
        catch (InvalidIdException e)
        {
            var response = new AppResponse<AppointmentDto>();
            response.setStatus("fail");
            response.setMessage(e.getMessage());
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
        }

    @GetMapping("/serchCanceledAppointment")
    public ResponseEntity<AppResponse<String>> cancelAppointment() {

        List<Appointment> list = service.serchCanceledAppointment();

        var response = new AppResponse<String>();
        response.setStatus("success");
        response.setMessage("All cancelled appointment");
        response.setList(list);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/searchAppointmentsByDoctorName")
    public ResponseEntity<AppResponse<String>> searchAppointmentsByDoctorName(@RequestBody AppointmentDto dto) {
        try {
            List<Appointment> list = service.searchAppointmentsByDoctorName(dto.getDoctorName());
            var response = new AppResponse<String>();
            response.setMessage("success");
            response.setStatus("Appointment by Doctor Name");
            response.setList(list);
            return new ResponseEntity(response, HttpStatus.ACCEPTED);

        } catch (InvalidDoctorName e) {
            var response = new AppResponse<AppointmentDto>();
            response.setStatus("fail");
            response.setMessage(e.getMessage());
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }
        }
