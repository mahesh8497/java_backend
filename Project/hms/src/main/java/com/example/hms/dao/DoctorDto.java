package com.example.hms.dao;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DoctorDto {


    @NotBlank
    @NotNull

    private int doctorid;
    private String doctorName;

    private String specialist;
}
