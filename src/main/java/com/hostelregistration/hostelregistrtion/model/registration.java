package com.hostelregistration.hostelregistrtion.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name="registration")
public class registration {

    @Id
    private Long id;
    private Instant registrationdate;

    @ManyToOne
    private room room;

    @OneToOne
    private student student;


}
