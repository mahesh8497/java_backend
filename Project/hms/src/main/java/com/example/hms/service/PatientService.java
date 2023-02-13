package com.example.hms.service;

import com.example.hms.dao.AppointmentDto;
import com.example.hms.dao.PatientDto;
import com.example.hms.entity.PatientEntity;
import com.example.hms.exception.InvalidIdException;

import java.util.List;

public interface PatientService {
    public PatientEntity registerPatient(PatientEntity patient);

    public List<PatientEntity> viewPatient();

    public PatientEntity viewById(Integer id);

    String deletePatient(Integer id);

    PatientEntity updatePatient(PatientEntity patientEntity, int id) ;

}
