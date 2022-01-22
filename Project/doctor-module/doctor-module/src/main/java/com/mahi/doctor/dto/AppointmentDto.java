package com.mahi.doctor.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class AppointmentDto {

private Long id;
    private String type;
    private LocalDate placed;
    private LocalDate appointmentDate;
    private String doctorName;
}
