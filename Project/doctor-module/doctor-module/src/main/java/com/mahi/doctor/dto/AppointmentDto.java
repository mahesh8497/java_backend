package com.mahi.doctor.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class AppointmentDto {

private Long id;
@NotNull
@NotBlank

    private String appointmentStatus;
    private String placed;
    private LocalDate appointmentDate;
    private String doctorName;


//    private String type;
//    private LocalDate placed;
//    private LocalDate appointment;
//    private String doctorName;
}
