package com.hostelregistration.hostelregistrtion.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Data
@Table(name="payment")
public class payment {

    @Id
    private Long paymentid;
    private Long price;
    private Long date;
}
