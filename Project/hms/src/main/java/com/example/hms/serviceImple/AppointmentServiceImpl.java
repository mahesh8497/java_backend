package com.example.hms.serviceImple;


import com.example.hms.dao.AppointmentDto;
import com.example.hms.entity.AppointmentEntity;
import com.example.hms.exception.InvalidIdException;
import com.example.hms.repository.AppointmentRepo;
import com.example.hms.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepo repository;

    @Override
    public AppointmentDto createAppointment(AppointmentDto dto) {

        var abc = new AppointmentEntity();

        abc.setAppointmentDate(dto.getAppointmentDate());
        // abc.setAppointment_id(dto.getAppointment_id());
        abc.setPatient_Name(dto.getPatient_Name());
        abc.setDoctorName(dto.getDoctorName());
        repository.save(abc);
        return dto;
    }

    @Override
    public AppointmentDto updateAppointment(AppointmentDto dto) throws InvalidIdException {
        AppointmentEntity doc = repository.findById(dto.getAppointment_id()).orElseThrow(
                () -> new InvalidIdException("enter a valid id :")
        );
        var doc1 = new AppointmentEntity();
        doc1.setAppointment_id(dto.getAppointment_id());
        doc1.setAppointmentDate(dto.getAppointmentDate());
        doc1.setDoctorName(dto.getDoctorName());
        doc1.setPatient_Name(dto.getPatient_Name());
        repository.save(doc1);
        return dto;
    }

    @Override
    public String deleteAppointment(Integer id) throws InvalidIdException {
            repository.deleteById(id);
    return "deleted Done";
    }

    @Override
    public List<AppointmentEntity> findAllApp() {
        return repository.findAll();
    }

}