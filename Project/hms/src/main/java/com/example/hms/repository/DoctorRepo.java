package com.example.hms.repository;

import com.example.hms.entity.DoctorEntity;
import com.example.hms.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends JpaRepository<DoctorEntity,Integer> {

        public DoctorEntity findBydoctorid(int id);


}
