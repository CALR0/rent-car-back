package com.example.RentCar.dto.Renta;

import java.time.LocalDate;

import lombok.Data;

@Data
public class RentaDTO {
    private Long idRenta;
    private Long idUsuario;
    private Long idCarro;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}
