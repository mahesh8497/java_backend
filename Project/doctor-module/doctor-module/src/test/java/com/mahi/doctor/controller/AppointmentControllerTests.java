package com.mahi.doctor.controller;
import com.mahi.doctor.domain.Appointment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppointmentControllerTests {

        @Autowired
        private TestRestTemplate template;
        @LocalServerPort
        private int port;
        @DisplayName("Get - Appointment - Checking Object Is non null")
        @Test
        public void testGetMethod(){

                String url = "http://"+"localhost"+":"+port+"/appointment";
                Appointment appointment = template.getForObject(url, Appointment.class);
                Assertions.assertNotNull(appointment);
        }

//        @DisplayName("Put - Appointment - deleting a  appointment")
//        @Test
//        public void testDeleteMethod(){
//                String url = "http://" + "localhost"+":"+port+"/appointment";
//                template.delete(url);
//        }

        @DisplayName("Put - Appointment - updating a  appointment")
        @Test
        public void testUpdateAppointMethod(){
                String url = "http://" + "localhost"+":"+port+"/appointment";
                Appointment appointment = template.getForObject(url,Appointment.class);
                Assertions.assertNotNull(appointment);
        }

        @DisplayName("Put - Appointment - cancel a  appointment")
        @Test
        public void testCancelAppointmentMethod() {
                String url="http://"+"localhost"+":"+port+"/cancelAppointment";
                Appointment appointment=template.getForObject(url,Appointment.class);
                Assertions.assertNotNull(appointment);
        }


//        @DisplayName("POST - appointment ")
//        @Test
//        public void testPostMethod(){
//                String url="http://"+"localhost"+":"+port+"/appointment";
//                var app =new Appointment();
//                app.setId(10L);
//                app.setAppointmentStatus("approved");
//                app.setAppointmentDate(LocalDate.now());
//                app.setDoctorName("vishal");
//                var re = template.postForEntity(url,app,Appointment.class);
//                Assertions.assertEquals(HttpStatus.OK,re.getStatusCode());
//
//        }
}
