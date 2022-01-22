package com.mahi.doctor.domain;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotNull
    @NotBlank
    @Column(unique = false, nullable = true)
    private String appointmentStatus;
    @Column(unique = false, nullable = true)
    private String placed;
    @Column(unique = false, nullable = true)
    private LocalDate appointmentDate;
    @Column(unique = false, nullable = false)
    private String doctorName;


}


