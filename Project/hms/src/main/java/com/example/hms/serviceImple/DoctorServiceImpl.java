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

    @Override
    public String deleteDoctor(Integer id) {

        doctorRepo.deleteById(id);

        return "deleted"+id;
    }

    @Override
    public DoctorEntity updateDoctor(DoctorEntity doctorEntity, int id) {
        DoctorEntity d=null;
        d=doctorRepo.findBydoctorid(id);
        if(d==null){
            return null;
        }
        else{
            d.setDoctorid(id);
            d.setDoctorName(d.getDoctorName());
            d.setSpecialist(d.getSpecialist());
           d=  this.doctorRepo.save(doctorEntity);
        }

        return d;
    }




}
