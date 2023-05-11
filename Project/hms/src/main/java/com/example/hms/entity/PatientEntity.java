package com.example.hms.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int patientId;
    private String patient_name;
    private String phoneNo;
    private int age;
    private String gender;

    @OneToOne(cascade = CascadeType.ALL)
    private AppointmentEntity app;



}

