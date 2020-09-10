package br.com.springContract.springcloudverifier;

import br.com.springContract.springcloudverifier.controller.ConvidadoController;
import br.com.springContract.springcloudverifier.service.ConvidadoService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureMessageVerifier
@EmbeddedKafka(partitions = 1, topics = {"v13jy9uz-default"})
@ActiveProfiles("test")
public class BaseTestClaxx {
    @Autowired
    private ConvidadoController convidadoController;

    @BeforeEach
    public void setupConvidadoService() {
        RestAssuredMockMvc.standaloneSetup(new ConvidadoController(new ConvidadoService()));
    }

    public void publicarMensagem(){
        this.convidadoController.publicarMensagem("teste vitor 2");
    }

}
