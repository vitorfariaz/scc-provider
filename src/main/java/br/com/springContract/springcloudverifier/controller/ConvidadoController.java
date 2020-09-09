package br.com.springContract.springcloudverifier.controller;


import br.com.springContract.springcloudverifier.config.Producer;
import br.com.springContract.springcloudverifier.model.Convidado;
import br.com.springContract.springcloudverifier.service.ConvidadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ConvidadoController {

    @Autowired
    private ConvidadoService convidadoService;

//    @Autowired
//    private KafkaTemplate<String, Convidado> kafkaTemplate;

    @Autowired
    private Producer producer;

    private static final String TOPIC = "v13jy9uz-default";

    public ConvidadoController(ConvidadoService convidadoService) {
        this.convidadoService = convidadoService;
    }

    @GetMapping("/todosConvidados")
    public List<Convidado> index(){
        return convidadoService.obterTodos();
    }


//    @PostMapping("/publicacao/{nome}")
//    public void publicarConvidado(String nomeConvidado){
//        Convidado convidado = new Convidado(nomeConvidado, "teste@kakfa.com", "1122334455", "12");
//        kafkaTemplate.send(TOPIC, convidado);
//    }

    @PostMapping("/publicar/{mensagem}")
    public void publicarMensagem(@PathVariable String mensagem){
        producer.send(mensagem);
    }


}
