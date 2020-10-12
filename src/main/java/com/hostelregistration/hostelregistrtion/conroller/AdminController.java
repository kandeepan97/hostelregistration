package com.hostelregistration.hostelregistrtion.conroller;


import com.hostelregistration.hostelregistrtion.model.Admin;
import com.hostelregistration.hostelregistrtion.repository.AdminRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class AdminController {
    private AdminRepository adminRepository;

    public AdminController(AdminRepository adminRepository) {
        super();
        this.adminRepository = adminRepository;
    }

    @GetMapping("/admins")
    Collection<Admin> admins(){
        return adminRepository.findAll();
    }

}
