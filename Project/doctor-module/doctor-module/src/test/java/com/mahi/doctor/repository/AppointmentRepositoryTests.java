package com.mahi.doctor.repository;

import com.mahi.doctor.domain.Appointment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.time.LocalDate;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AppointmentRepositoryTests {

    @Autowired
    private AppointmentRepository repository;
    @DisplayName("Appointment Repo : Creating Appointment")
    @Test
    void testCreateAbc() {

        var app = new Appointment();
        app.setId(565L);
        app.setAppointmentStatus("xyz");
        app.setAppointmentDate((LocalDate.now()));
        repository.save(app);
    }
}