package com.example.RentCar.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "carros")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCarro;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private Integer precio;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private String ciudad;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String imagen;
}
