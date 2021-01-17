package br.com.springContract.springcloudverifier;

import br.com.springContract.springcloudverifier.config.GuestKafkaProducer;
import br.com.springContract.springcloudverifier.controller.GuestController;
import br.com.springContract.springcloudverifier.model.Guest;
import br.com.springContract.springcloudverifier.service.GuestService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.kafka.test.context.EmbeddedKafka;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMessageVerifier
@EmbeddedKafka(partitions = 1, topics = {"v13jy9uz-default"})
public class BaseTest {

    @Autowired
    private GuestKafkaProducer guestKafkaProducer;

    @Mock
    private GuestService guestService;

    @BeforeEach
    public void setupGuestService() {
        Mockito
                .lenient()
                .when(guestService.getAllGuests())
                .thenReturn(GuestFactory.build());

        RestAssuredMockMvc.standaloneSetup(new GuestController(guestService));

    }

    public void publishMessage(){
        Guest guest = GuestFactory.build().get(0);
        this.guestKafkaProducer.send(guest);
    }

}
