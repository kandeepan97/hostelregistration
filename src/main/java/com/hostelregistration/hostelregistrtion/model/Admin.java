package com.hostelregistration.hostelregistrtion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="admin")
public class Admin {

    @Id
    private String adminId;
    private String email;
    private String password;


}
