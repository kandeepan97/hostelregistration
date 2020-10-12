package com.hostelregistration.hostelregistrtion.repository;

import com.hostelregistration.hostelregistrtion.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository <Student, String> {
    Student findByFirstName (String name);
    Student findByEmail (String email);
    Student getByStudentid (String studentid);

}
