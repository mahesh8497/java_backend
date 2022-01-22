package com.mahi.doctor.repository;

import com.mahi.doctor.domain.Appointment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.time.LocalDate;

public class AppointmentRepositoryTests {

    @Autowired
    private AppointmentRepository repository;

    @DisplayName("Abc Repo : Creating Abc")
    @Test
    void testCreateAbc() {

        var abc = new Appointment();
        abc.setId(565L);
        abc.setDoctorName("abc");
        abc.setAppointmentDate((LocalDate.now()));

        repository.save(abc);
    }
}
