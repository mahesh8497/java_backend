package com.User.service.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "micro_user")
public class User {

    @Id
    @Column(name="ID")
    private String userId;
    @Column(name="NAME",length = 20)
    private String name;
    @Column(name="EMAIL")
    private String email;
    @Column(name="ABOUT")
    private String about;


    @Transient
    private List<Rating> ratings=new ArrayList<>();
}
