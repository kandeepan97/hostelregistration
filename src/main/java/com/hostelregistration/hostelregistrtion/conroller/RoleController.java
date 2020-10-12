package com.hostelregistration.hostelregistrtion.conroller;


import com.hostelregistration.hostelregistrtion.model.Role;
import com.hostelregistration.hostelregistrtion.repository.RoleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class RoleController {
    private RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        super();
        this.roleRepository = roleRepository;
    }

    @GetMapping("/roles")
    Collection<Role> roles(){
        return roleRepository.findAll();
    }

}
