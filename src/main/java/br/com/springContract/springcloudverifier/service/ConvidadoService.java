package br.com.springContract.springcloudverifier.service;

import br.com.springContract.springcloudverifier.model.Convidado;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class ConvidadoService {

    private List<Convidado> convidados = new ArrayList<>(
                    Arrays.asList(new Convidado("Vitor", "vitinho@test.com", "443322111","13"),
                                  new Convidado("Vitor2", "vitinho2@test.com", "111111111","11")
                    )
            );

    public List<Convidado> obterTodos(){
        return convidados;
    }

}
