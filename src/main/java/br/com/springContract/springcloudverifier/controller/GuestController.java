package br.com.springContract.springcloudverifier.controller;


import br.com.springContract.springcloudverifier.config.GuestKafkaProducer;
import br.com.springContract.springcloudverifier.model.Guest;
import br.com.springContract.springcloudverifier.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GuestController {

    @Autowired
    private GuestService guestService;

    @Autowired
    private GuestKafkaProducer guestKafkaProducer;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping("/guests")
    public List<Guest> allGuests(){
        return guestService.getAllGuests();
    }

    @PostMapping("/publish/{guestName}")
    public ResponseEntity<Guest> publishMessage(@PathVariable String guestName){
        Guest guest = new Guest(guestName);
        guestKafkaProducer.send(guest);
        guestService.getAllGuests().add(guest);
        return ResponseEntity.status(HttpStatus.CREATED).body(guest);
    }
}
