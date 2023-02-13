package com.example.hms.serviceImple;

import com.example.hms.dao.PatientDto;
import com.example.hms.entity.AppointmentEntity;
import com.example.hms.entity.PatientEntity;
import com.example.hms.exception.InvalidIdException;
import com.example.hms.exception.ResourceNotFoundException;
import com.example.hms.repository.PatientRepo;
import com.example.hms.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepo patientRepo;

    @Override
    public PatientEntity registerPatient(PatientEntity patient) {
        return patientRepo.save(patient);
    }

    @Override
    public List<PatientEntity> viewPatient() {
        return patientRepo.findAll();
    }

    @Override
    public PatientEntity viewById(Integer id) {
        return patientRepo.getById(id);
    }

    @Override
    public String deletePatient(Integer id) {
        patientRepo.deleteById(id);
        return "deleted"+id;

    }


    public PatientEntity updatePatient(PatientEntity patientEntity,int id)  {
        PatientEntity patient=null;
        patient=patientRepo.findBypatientId(id);
        if(patient==null){
            return null;
        }
        else{
            patient.setPatientId(id);

            patient=this.patientRepo.save(patientEntity);
        }
        return patient;
    }

}




