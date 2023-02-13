package com.example.hms.dao;


import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DoctorDto {
    private int doctorid;
    private String doctorName;
    private String specialist;
}
