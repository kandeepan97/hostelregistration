
package com.hostelregistration.hostelregistrtion.conroller;


        import com.hostelregistration.hostelregistrtion.model.Hostel;
        import com.hostelregistration.hostelregistrtion.model.Room;
        import com.hostelregistration.hostelregistrtion.repository.HostelRepository;
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
public class HostelController {
    private HostelRepository hostelRepository;

    public HostelController(HostelRepository hostelRepository) {
        super();
        this.hostelRepository = hostelRepository;
    }

    @GetMapping("/hostels")
    Collection<Hostel> hostels(){
        return hostelRepository.findAll();
    }
    @PostMapping("/hostel")
    ResponseEntity<Hostel> createHostel(@Validated @RequestBody Hostel hostel) throws URISyntaxException {
        Hostel result = hostelRepository.save(hostel);
        return ResponseEntity.created(new URI("/api/hostel" + result.getHOSTELID())).body(result);
    }
    @GetMapping("/hostel/{id}")
    ResponseEntity<?> getHostel(@PathVariable String id){
        Optional<Hostel> hostel =hostelRepository.findById(id);
        return hostel.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/hostel")
    ResponseEntity<Hostel> updateHostel(@Validated @RequestBody Hostel hostel){
        Hostel result= hostelRepository.save(hostel);
        return ResponseEntity.ok().body(result);
    }


}
