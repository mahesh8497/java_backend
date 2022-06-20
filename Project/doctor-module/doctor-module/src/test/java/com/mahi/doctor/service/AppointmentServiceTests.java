package com.mahi.doctor.service;

import com.mahi.doctor.domain.Appointment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class AppointmentServiceTests {

    @Test
    void testObjectCreation() {
        var appointment = new Appointment();
        Assertions.assertNotNull(appointment);
    }
}
