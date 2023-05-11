package com.example.hms.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int appointment_id;


    @Column(unique = true, nullable = true)
    private String doctorName;
    private String patient_Name;

    @Column(unique = false, nullable = false)
    private LocalDate appointmentDate;



}
