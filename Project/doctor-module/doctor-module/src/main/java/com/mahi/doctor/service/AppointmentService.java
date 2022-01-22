package com.mahi.doctor.service;

import com.mahi.doctor.domain.Appointment;
import com.mahi.doctor.dto.AppointmentDto;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {

    AppointmentDto createAppointment(AppointmentDto dto);

    String updateAppointment(Long id, LocalDate Appointment);


    String cancelAppointment(Long id);

    List<Appointment> serchCanceledAppointment();

    List<Appointment> searchAppointmentsByDoctorName(String s);


    }
