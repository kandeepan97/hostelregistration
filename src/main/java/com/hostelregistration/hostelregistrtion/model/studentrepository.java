package com.hostelregistration.hostelregistrtion.model;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hostelregistration.hostelregistrtion.model.student;

public interface studentrepository extends JpaRepository <student, Long> {
    student findByName (String name);
}
