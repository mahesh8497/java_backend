package com.example.hms.repository;

import com.example.hms.dao.PatientDto;
import com.example.hms.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<PatientEntity,Integer> {
    public PatientEntity findBypatientId(int id);
}
