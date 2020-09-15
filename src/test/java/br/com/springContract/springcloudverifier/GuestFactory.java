package br.com.springContract.springcloudverifier;

import br.com.springContract.springcloudverifier.model.Guest;
import br.com.springContract.springcloudverifier.model.Address;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class GuestFactory {

    public static List<Guest> build(){
        return Arrays.asList(
                new Guest("Vitor", "vitinho@test.com", 443322111L,13, new Address("2",123), LocalDate.now()),
                new Guest("Vitor2", "vitinho2@test.com", 111111111L,11, new Address("bakerStreet",123), LocalDate.now()));
    }
}
