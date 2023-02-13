package com.example.hms.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

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
    private String name;
    private String phoneNo;
    private int age;
    private String gender;

//    @OneToOne(cascade = CascadeType.ALL)
// //   @JoinColumn(name = "appointment_id",referencedColumnName = "appointment_id")
//    private AppointmentEntity appointmentEntity;

}