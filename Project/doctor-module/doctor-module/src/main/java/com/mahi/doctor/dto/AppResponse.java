package com.mahi.doctor.dto;


import com.mahi.doctor.domain.Appointment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AppResponse <T>{
    private String status;
    private String message;
    private T body;
    private List<Appointment> list;
}
