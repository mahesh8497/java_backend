package com.mahi.doctor.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppointmentTests {

    @DisplayName("Domain : Checking Object Creation")
    @Test
    void testObjectCreation() {
        var abc = new Appointment();
        Assertions.assertNotNull(abc);
    }

    @DisplayName("Domain : Checking getters and setters")
    @Test
    void testObjectGettersSetters() {
        var abc = new Appointment();
        abc.setId(10L);
        abc.setAppointmentDate((LocalDate.of(2021,1,1)));
        abc.setDoctorName("abc");

        Assertions.assertEquals(10, abc.getId());
        Assertions.assertEquals(
                (LocalDate.of(2021,1,1)),

                abc.getAppointmentDate()
        );
        Assertions.assertEquals("abc", abc.getDoctorName());
        Assertions.assertEquals(10, abc.getId());
    }
}
