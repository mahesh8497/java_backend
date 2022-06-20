package com.mahi.doctor.repository;

import com.mahi.doctor.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@EnableJpaRepositories
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
//    Optional<Appointment> findById(Long id);

    List<Appointment> findAllByAppointmentStatus(String s);
    List<Appointment> getByDoctorName(String s);

}
