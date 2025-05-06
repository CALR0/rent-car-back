package com.example.RentCar.controllers;

import java.time.LocalDate;

import lombok.Data;

@Data
public class RentalFormData {
    private String marca;
    private String modelo;
    private Integer precio;
    private String ciudad;
    private String color;
    private String nombre;
    private String apellido;
    private Long cedula;
    private String direccion;
    private Long telefono;
    private LocalDate fechaInicio;
    private int duracion;
}
