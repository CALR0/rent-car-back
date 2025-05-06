
package com.example.RentCar.dto.Carro;

import java.util.Date;

import lombok.Data;

@Data
public class CarroDTO {
    private Long idCarro;
    private String marca;
    private String modelo;
    private Integer precio;
    private String color;
    private String ciudad;
    private String imagen;
}
