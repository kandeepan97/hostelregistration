package com.hostelregistration.hostelregistrtion.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Entity
@Data
@Table(name="hostel")
public class Hostel {
    @Id
    private String hostelid;
    private String hostelName;
    private Long numberOfRooms;
    private String wardenId;
    private String hostelType;


    public String getHOSTELID() {
        return hostelid;
    }
}
