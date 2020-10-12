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
public class Registration {

    @Id
    private String registrationId;
    private String registrationDate;
    private String hostelId;
    private String roomId;
    private String studentId;




}
