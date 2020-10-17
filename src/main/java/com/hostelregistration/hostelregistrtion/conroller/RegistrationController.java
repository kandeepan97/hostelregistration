package com.hostelregistration.hostelregistrtion.conroller;


import com.hostelregistration.hostelregistrtion.model.Registration;
import com.hostelregistration.hostelregistrtion.model.Room;
import com.hostelregistration.hostelregistrtion.repository.RegistrationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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
    Collection<Registration> registrations() {
        return registrationRepository.findAll();
    }

    @PostMapping("/registration")
    ResponseEntity<Registration> registerRoom(@Validated @RequestBody Registration registration) throws URISyntaxException {
        Registration result = registrationRepository.save(registration);
        return ResponseEntity.created(new URI("/api/registration" + result.getREGISTRATIONID())).body(result);

    }

}

