package br.com.springContract.springcloudverifier.service;

import br.com.springContract.springcloudverifier.model.Guest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    private List<Guest> guests;

    public List<Guest> getAllGuests(){
        return guests;
    }

    public GuestService(List<Guest> guests) {
        this.guests = guests;
    }
}
