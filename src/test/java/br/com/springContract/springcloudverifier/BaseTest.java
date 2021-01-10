package br.com.springContract.springcloudverifier;

import br.com.springContract.springcloudverifier.config.GuestKafkaProducer;
import br.com.springContract.springcloudverifier.controller.GuestController;
import br.com.springContract.springcloudverifier.model.Guest;
import br.com.springContract.springcloudverifier.service.GuestService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.kafka.test.context.EmbeddedKafka;

@SpringBootTest
@AutoConfigureMessageVerifier
@EmbeddedKafka(partitions = 1, topics = {"v13jy9uz-default"})
public class BaseTest {

    @Autowired
    private GuestKafkaProducer guestKafkaProducer;

    @BeforeEach
    public void setupGuestService() {
        RestAssuredMockMvc.standaloneSetup(new GuestController(new GuestService(GuestFactory.build())));
    }

    public void publishMessage(){
        Guest guest = GuestFactory.build().get(0);
        this.guestKafkaProducer.send(guest);
    }

}
