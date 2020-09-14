package br.com.springContract.springcloudverifier;

import br.com.springContract.springcloudverifier.model.Convidado;
import br.com.springContract.springcloudverifier.model.Endereco;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ConvidadoFactory {

    public static List<Convidado> build(){
        return Arrays.asList(
                new Convidado("Vitor", "vitinho@test.com", 443322111L,13, new Endereco("2",123), LocalDate.now()),
                new Convidado("Vitor2", "vitinho2@test.com", 111111111L,11, new Endereco("bakerStreet",123), LocalDate.now()));
    }
}
