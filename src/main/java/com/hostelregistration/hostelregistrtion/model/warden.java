package com.hostelregistration.hostelregistrtion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="warden")
public class Warden {

    @Id
    private String wardenid;
    private String email;
    private Long mobileNumber;
    private String firstName;
    private String lastName;
    private String hostelId;
    private String password;


    public String getWARDENID() {
        return wardenid;
    }
}
