package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Stu_Tab",uniqueConstraints = @UniqueConstraint(
        name="emailId_unique",columnNames ="email_address"))
@Entity
@Builder
public class Student {

    @Id
    @SequenceGenerator(name="student_sequence ",sequenceName = "student_sequence ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_sequence")
    private long studentId;
    private String firstName;
    private String lastName;

    @Column(
            name = "email_address",
            nullable=false)

    private String emailId;

    @Embedded
    private Guardian guardian;


}
