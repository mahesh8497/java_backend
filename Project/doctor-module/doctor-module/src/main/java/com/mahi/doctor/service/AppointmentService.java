package com.mahi.doctor.service;

import com.mahi.doctor.domain.Appointment;
import com.mahi.doctor.dto.AppointmentDto;
import com.mahi.doctor.exception.InvalidDoctorName;
import com.mahi.doctor.exception.InvalidIdException;

import java.util.List;

public interface AppointmentService {

    AppointmentDto createAppointment(AppointmentDto dto);

AppointmentDto updateAppointment(AppointmentDto dto) throws InvalidIdException;


    String cancelAppointment(Long id) throws  InvalidIdException;

    List<Appointment> serchCanceledAppointment();

    List<Appointment> searchAppointmentsByDoctorName(String s) throws InvalidDoctorName;





    }
