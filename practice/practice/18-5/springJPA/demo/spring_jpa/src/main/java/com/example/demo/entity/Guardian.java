package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "Name",column = @Column(name = "guardian_name")
        ),
        @AttributeOverride(
                name = "Email",column = @Column(name = "guardian_email")
        ),
        @AttributeOverride(
                name = "Mobile",column = @Column(name = "guardian_mobile")
        )

})
public class Guardian {
    private String Name;
    private String Email;
    private String Mobile;
}
