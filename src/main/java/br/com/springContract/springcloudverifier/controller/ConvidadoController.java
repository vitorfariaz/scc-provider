package br.com.springContract.springcloudverifier.controller;


import br.com.springContract.springcloudverifier.model.Convidado;
import br.com.springContract.springcloudverifier.service.ConvidadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConvidadoController {

    @Autowired
    private ConvidadoService convidadoService;

    public ConvidadoController(ConvidadoService convidadoService) {
        this.convidadoService = convidadoService;
    }

    @GetMapping("/todosConvidados")
    public List<Convidado> index(){
        return convidadoService.obterTodos();
    }

}
