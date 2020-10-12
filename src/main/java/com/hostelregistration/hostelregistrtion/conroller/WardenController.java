
package com.hostelregistration.hostelregistrtion.conroller;


import com.hostelregistration.hostelregistrtion.model.Warden;
import com.hostelregistration.hostelregistrtion.repository.WardenRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class WardenController {
    private WardenRepository wardenRepository;

    public WardenController(WardenRepository wardenRepository) {
        super();
        this.wardenRepository = wardenRepository;
    }

    @GetMapping("/wardens")
    Collection<Warden> wardens(){
        return wardenRepository.findAll();
    }

    @PostMapping("/warden")
        ResponseEntity<Warden> createWarden(@Validated @RequestBody Warden warden)throws URISyntaxException {
            Warden result = wardenRepository.save(warden);
            return ResponseEntity.created(new URI("/api/warden" + result.getWARDENID())).body(result);

    }

    @GetMapping("/warden/{id}")
    ResponseEntity<?> getWarden(@PathVariable String id){
        Optional<Warden> warden =wardenRepository.findById(id);
        return warden.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/warden")
    ResponseEntity<Warden> updateWarden(@Validated @RequestBody Warden warden){
        Warden result= wardenRepository.save(warden);
        return ResponseEntity.ok().body(result);
    }



}