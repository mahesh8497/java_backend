package com.example.hms.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AppointmentDto {



    private Integer appointment_id;

    @NotNull
    @NotBlank
    private String doctorName;

    @NotNull
    @NotBlank
    private String patient_Name;
    private LocalDate appointmentDate;


}
