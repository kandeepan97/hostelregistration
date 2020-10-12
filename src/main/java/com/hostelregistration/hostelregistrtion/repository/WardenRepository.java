package com.hostelregistration.hostelregistrtion.repository;


import com.hostelregistration.hostelregistrtion.model.Warden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WardenRepository extends JpaRepository <Warden,String> {
    Warden findByFirstName (String name);
}
