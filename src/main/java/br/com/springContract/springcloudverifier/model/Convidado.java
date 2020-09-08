package br.com.springContract.springcloudverifier.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@Data
@EqualsAndHashCode
@ToString
@JsonSerialize
public class Convidado {

    private  String nome;
    private  String email;
    private  String telefone;
    private String idade;

    public Convidado() {
    }

    public Convidado(String nome, String email, String telefone, String idade) {

        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.idade =  idade;
    }
}

