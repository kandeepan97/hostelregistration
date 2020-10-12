package com.hostelregistration.hostelregistrtion.conroller;


import com.hostelregistration.hostelregistrtion.model.Registration;
import com.hostelregistration.hostelregistrtion.repository.RegistrationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class RegistrationController {
    private RegistrationRepository registrationRepository;

    public RegistrationController(RegistrationRepository registrationRepository) {
        super();
        this.registrationRepository = registrationRepository;
    }

    @GetMapping("/registrations")
    Collection<Registration> registrations(){
        return registrationRepository.findAll();
    }

}

