package com.example.hms.dao;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PatientDto {

    private int patientId;
    private String patient_name;
    private String phoneNo;
    private int age;
    private String gender;


//    private Integer appointment_id;
}
