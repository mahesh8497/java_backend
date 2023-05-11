package com.example.hms.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer doctorid;
    private String doctorName;
    private String specialist;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_addPE")
    private PatientEntity PE;
}
