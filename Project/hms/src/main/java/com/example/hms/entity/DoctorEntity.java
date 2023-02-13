package com.example.hms.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer doctorid;

    @Column(unique = true, nullable = true)
    private String doctorName;


    private String specialist;
}
