package br.com.springContract.springcloudverifier.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

@Data
@EqualsAndHashCode
@ToString
public class Convidado {

    private String nome;
    private String email;
    private Long telefone;
    private Integer idade;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private LocalDate anoNascimento;
    private Endereco endereco;

    public Convidado() {
    }

    public Convidado(String nome) {
        this.nome = nome;
        this.email = "email@vitinho";
        this.telefone = 5544332233L;
        this.idade =  20;
        this.anoNascimento = LocalDate.now();
        this.endereco = new Endereco("bakerStreet", 123);
    }

    public Convidado(String nome, String email, Long telefone, Integer idade, Endereco endereco, LocalDate anoNascimento) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.idade =  idade;
        this.endereco = endereco;
        this.anoNascimento = anoNascimento;
    }
}

