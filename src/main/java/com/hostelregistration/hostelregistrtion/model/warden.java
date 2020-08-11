package com.hostelregistration.hostelregistrtion.model;

import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Calendar;
import java.util.Locale;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="warden")
public class warden {

    @Id
    private Long wardenid;
    private String name;
    private String email;
    private Long mobileno;
    private String firstname;
    private String lastname;
    private Long hostelid;


}
