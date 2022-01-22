package com.mahi.doctor.domain;


import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(unique = false, nullable = true)
    private String type;

    @Column(unique = false, nullable = true)
    private LocalDate placed;

    @Column(unique = false, nullable = true)
    private LocalDate appointmentDate;

    @Column(unique = false, nullable = false)
    private String doctorName;


}


