package br.com.springContract.springcloudverifier.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

@Data
@EqualsAndHashCode
@ToString
public class Guest {

    private String name;
    private String email;
    private Long phone;
    private Integer age;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private Address address;

    public Guest() {
    }

    public Guest(String name) {
        this.name = name;
        this.email = "email@vitinho";
        this.phone = 5544332233L;
        this.age =  20;
        this.birthDate = LocalDate.now();
        this.address = new Address("bakerStreet", 123);
    }

    public Guest(String name, String email, Long phone, Integer age, Address address, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.address = address;
        this.birthDate = birthDate;
    }
}

