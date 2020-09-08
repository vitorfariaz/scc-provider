package br.com.springContract.springcloudverifier;

import br.com.springContract.springcloudverifier.controller.ConvidadoController;
import br.com.springContract.springcloudverifier.service.ConvidadoService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;

public class BaseTestClaxx {
    @BeforeEach
    public void setupConvidadoService() {
        RestAssuredMockMvc.standaloneSetup(new ConvidadoController(new ConvidadoService()));
    }

}
