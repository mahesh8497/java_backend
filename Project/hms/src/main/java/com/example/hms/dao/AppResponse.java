package com.example.hms.dao;

import com.example.hms.entity.AppointmentEntity;
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
        private List<AppointmentEntity> list;
    }
