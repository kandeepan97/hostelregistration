package com.hostelregistration.hostelregistrtion.repository;

import com.hostelregistration.hostelregistrtion.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration,String> {


}
