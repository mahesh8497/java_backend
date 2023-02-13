package com.example.hms.repository;

import com.example.hms.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<AppointmentEntity,Integer> {


}
