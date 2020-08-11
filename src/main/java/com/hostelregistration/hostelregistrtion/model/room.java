package com.hostelregistration.hostelregistrtion.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Locale;
import java.util.Set;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Data
@Table(name="room")
public class room {

    @Id
    private Long roomid;
    private Long hostelid;
    private Long noofbeds;
    private Long noofstudentsnow;
    private Long floorno;


}
