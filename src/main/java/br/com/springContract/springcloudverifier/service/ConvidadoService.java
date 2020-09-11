package br.com.springContract.springcloudverifier.service;

import br.com.springContract.springcloudverifier.model.Convidado;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConvidadoService {

    private List<Convidado> convidados;

    public List<Convidado> obterTodos(){
        return convidados;
    }

    public ConvidadoService(List<Convidado> convidados) {
        this.convidados = convidados;
    }
}
