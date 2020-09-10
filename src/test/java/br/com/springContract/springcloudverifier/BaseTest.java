package br.com.springContract.springcloudverifier;

import br.com.springContract.springcloudverifier.config.Producer;
import br.com.springContract.springcloudverifier.controller.ConvidadoController;
import br.com.springContract.springcloudverifier.service.ConvidadoService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@AutoConfigureMessageVerifier
@EmbeddedKafka(partitions = 1, topics = {"v13jy9uz-default"})
public class BaseTest {

    @Autowired
    private Producer producer;

    @BeforeEach
    public void setupConvidadoService() {
        RestAssuredMockMvc.standaloneSetup(new ConvidadoController(new ConvidadoService()));
    }

    public void publicarMensagem(){
        this.producer.send("teste vitor 2");
    }

}
