package com.example.hms.service;

import com.example.hms.dao.AppointmentDto;
import com.example.hms.entity.AppointmentEntity;
import com.example.hms.exception.InvalidIdException;

import java.util.List;

public interface AppointmentService {


    AppointmentDto createAppointment(AppointmentDto dto);

    AppointmentDto updateAppointment(AppointmentDto dto) throws InvalidIdException;

     String deleteAppointment(Integer id) throws InvalidIdException;



    List<AppointmentEntity> findAllApp();





}
