package com.hostelregistration.hostelregistrtion.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="student")
public class student {

    @Id
    private Long studentid;
    private String firstname;
    private String lastnmae;
    private String email;
    private String address;
    private Long mobileno;
    private Long year;
    private String faculty;
    private String department;
    private Long roomid;
    private Long hostelid;
    private String password;




}
