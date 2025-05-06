package com.example.RentCar.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rentas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Renta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRenta;

    @ManyToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    private Usuario idUsuario;

    @ManyToOne
    @JoinColumn(name = "idCarro", referencedColumnName = "idCarro")
    private Carro idCarro;

    @Column(nullable = false)
    private LocalDate fechaInicio;

    @Column(nullable = false)
    private LocalDate fechaFin;
}
