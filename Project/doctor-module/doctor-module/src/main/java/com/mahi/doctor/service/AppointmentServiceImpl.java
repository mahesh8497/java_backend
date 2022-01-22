package com.mahi.doctor.service;

import com.mahi.doctor.domain.Appointment;
import com.mahi.doctor.dto.AppointmentDto;
import com.mahi.doctor.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    @Override
    public AppointmentDto createAppointment(AppointmentDto dto) {

        var abc = new Appointment();
        abc.setType(dto.getType());
        abc.setId(dto.getId());
        abc.setAppointmentDate(dto.getAppointmentDate());
        abc.setPlaced(dto.getPlaced());
        abc.setDoctorName(dto.getDoctorName());
        repository.save(abc);
        return dto;
    }

    @Override
    public String updateAppointment(Long id, LocalDate Appointment) {
        Appointment op = repository.getById(id);

//       LocalDate existingType = op.getAppointmentDate();
        LocalDate newAppointment=Appointment;
        Appointment baNew = new Appointment();
        baNew.setAppointmentDate(newAppointment);
        baNew.setId(op.getId());
        baNew.setType(op.getType());
        baNew.setPlaced(op.getPlaced());
        baNew.setDoctorName(op.getDoctorName());
        repository.save(baNew);
        return baNew.getType();
    }


    @Override
    public String cancelAppointment(Long id){
        Appointment op = repository.getById(id);
        String existingType = op.getType();
        String newType= "cancel";
        op.setType(newType);
//        Appointment baNew = new Appointment();
//        baNew.setAppointmentDate(op.getAppointmentDate());
//        baNew.setId(op.getId());
//        baNew.setType(newType);
//        baNew.setPlaced(op.getPlaced());
//        baNew.setDoctorName(op.getDoctorName());
        repository.save(op);
        return op.getType();
    }

    @Override
    public List<Appointment> serchCanceledAppointment() {

        List<Appointment> list=repository.findAllByType("cancel");
        return list;
    }

    @Override
    public List<Appointment> searchAppointmentsByDoctorName(String s) {

        List<Appointment> list=repository.findAllByDoctorName(s);
        return list;
    }



}



