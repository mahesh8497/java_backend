package com.example.hms.service;

import com.example.hms.entity.DoctorEntity;

import java.util.List;

public interface DoctorService {

    public DoctorEntity saveDoctor(DoctorEntity doctor);

    List<DoctorEntity>viewDoctors();


    String deleteDoctor(Integer id);


    DoctorEntity updateDoctor(DoctorEntity doctorEntity, int id) ;

}
