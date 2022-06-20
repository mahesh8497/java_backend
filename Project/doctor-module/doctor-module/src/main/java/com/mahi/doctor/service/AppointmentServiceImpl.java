package com.mahi.doctor.service;

import com.mahi.doctor.domain.Appointment;
import com.mahi.doctor.dto.AppointmentDto;
import com.mahi.doctor.exception.InvalidDoctorName;
import com.mahi.doctor.exception.InvalidIdException;
import com.mahi.doctor.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    @Override
    public AppointmentDto createAppointment(AppointmentDto dto) {

        var abc = new Appointment();
        abc.setAppointmentStatus(dto.getAppointmentStatus());
        abc.setId(dto.getId());
        abc.setAppointmentDate(dto.getAppointmentDate());
        abc.setPlaced(dto.getPlaced());
        abc.setDoctorName(dto.getDoctorName());
        repository.save(abc);
        return dto;
    }
@Override
public AppointmentDto updateAppointment(AppointmentDto dto) throws InvalidIdException{
    Appointment doc = repository.findById(dto.getId()).orElseThrow(
            () -> new InvalidIdException("enter a valid id :")
    );
    var doc1 = new Appointment();
    doc1.setId(dto.getId());
    doc1.setAppointmentStatus(dto.getAppointmentStatus());
    doc1.setAppointmentDate(dto.getAppointmentDate());
    doc1.setPlaced(dto.getPlaced());
    doc1.setDoctorName(dto.getDoctorName());
    repository.save(doc1);
    return dto;
}


    @Override
    public String cancelAppointment(Long id) throws  InvalidIdException{

        Appointment op = repository.findById(id).orElseThrow(
                () -> new InvalidIdException("Enter valid Id"));
        String existingType = op.getAppointmentStatus();
        String newType= "cancel";
        op.setAppointmentStatus(newType);
        repository.save(op);
        return op.getAppointmentStatus();
    }

    @Override
    public List<Appointment> serchCanceledAppointment() {

        List<Appointment> list=repository.findAllByAppointmentStatus("cancel");
        return list;
    }

    @Override
    public List<Appointment> searchAppointmentsByDoctorName(String s) throws InvalidDoctorName {

        List<Appointment> list=repository.getByDoctorName(s);
        if(list.size()>0)
            return list;
        else
            throw new InvalidDoctorName("Invalied doctor name");
    }





}



