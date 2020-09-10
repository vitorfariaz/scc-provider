package br.com.springContract.springcloudverifier.controller;


import br.com.springContract.springcloudverifier.config.Producer;
import br.com.springContract.springcloudverifier.model.Convidado;
import br.com.springContract.springcloudverifier.service.ConvidadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConvidadoController {

    @Autowired
    private ConvidadoService convidadoService;

    @Autowired
    private Producer producer;

    public ConvidadoController(ConvidadoService convidadoService) {
        this.convidadoService = convidadoService;
    }

    @GetMapping("/todosConvidados")
    public List<Convidado> index(){
        return convidadoService.obterTodos();
    }

    @PostMapping("/publicar/{mensagem}")
    public void publicarMensagem(@PathVariable String mensagem){
        producer.send(mensagem);
    }

}
