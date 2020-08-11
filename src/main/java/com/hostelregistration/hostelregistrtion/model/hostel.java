package com.hostelregistration.hostelregistrtion.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Entity
@Data
@Table(name="hostel")
public class hostel {
    @Id
    private Long hostelid;
    private String hostelname;
    private Long noofrooms;
    private Long idofincarge;


}
