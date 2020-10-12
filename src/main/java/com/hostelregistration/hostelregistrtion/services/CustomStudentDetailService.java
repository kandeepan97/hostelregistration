package com.hostelregistration.hostelregistrtion.services;


import com.hostelregistration.hostelregistrtion.model.Student;
import com.hostelregistration.hostelregistrtion.repository.StudentRepository;
import org.apache.naming.factory.SendMailFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomStudentDetailService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Student student = studentRepository.findByEmail(email);
        if (student == null) new UsernameNotFoundException("user not found");
       // return student;
        return null;
    }

     @Transactional
             public Student loadUserByStudentid(String studentid){
         Student student = studentRepository.getByStudentid(studentid);
         if (student == null) new UsernameNotFoundException("user not found");
         return student;
    }
}
