package com.example.RentCar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.RentCar.entities.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

    @Query("SELECT c FROM Carro c WHERE lower(c.marca) LIKE lower(?1) AND lower(c.modelo) LIKE lower(?2) AND lower(c.ciudad) LIKE lower(?3)")
    Carro findByMarcaAndModelo(String marca, String modelo, String ciudad);
}
