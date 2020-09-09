package br.com.springContract.springcloudverifier.controller;


import br.com.springContract.springcloudverifier.model.Convidado;
import br.com.springContract.springcloudverifier.service.ConvidadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConvidadoController {

    @Autowired
    private ConvidadoService convidadoService;

    @Autowired
    private KafkaTemplate<String, Convidado> kafkaTemplate;

    private static final String TOPIC = "1s0xs9ci-default";

    public ConvidadoController(ConvidadoService convidadoService) {
        this.convidadoService = convidadoService;
    }

    @GetMapping("/todosConvidados")
    public List<Convidado> index(){
        return convidadoService.obterTodos();
    }


    @PostMapping("/publicacao/{nome}")
    public void publicarConvidado(String nomeConvidado){
        Convidado convidado = new Convidado(nomeConvidado, "teste@kakfa.com", "1122334455", "12");
        kafkaTemplate.send(TOPIC, convidado);
    }

}
