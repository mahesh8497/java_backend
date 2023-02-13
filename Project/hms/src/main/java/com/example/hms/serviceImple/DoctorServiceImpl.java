package com.example.hms.serviceImple;

import com.example.hms.entity.DoctorEntity;
import com.example.hms.repository.DoctorRepo;
import com.example.hms.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;


    @Override
    public DoctorEntity saveDoctor(DoctorEntity doctor) {
        return  doctorRepo.save(doctor);
    }

    @Override
    public List<DoctorEntity> viewDoctors() {
        return doctorRepo.findAll();
    }

//    @Override
//    public DoctorEntity updateDoctor(DoctorEntity doctorEntity,int id) {
//        DoctorEntity doctor=null;
//        doctor=doctorRepo.findBydoctortId(id);
//        if(doctor==null){
//            return null;
//        }
//        else {
//            doctor.setDoctorid(id);
//          doctor=this.doctorRepo.save(doctorEntity);
//        }
//        return doctor;
//    }


}
