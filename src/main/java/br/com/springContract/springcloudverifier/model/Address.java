package br.com.springContract.springcloudverifier.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Address {
    private String street;
    private Integer houseNumber;
}
