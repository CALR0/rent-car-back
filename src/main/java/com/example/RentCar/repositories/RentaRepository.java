package com.example.RentCar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RentCar.entities.Renta;

@Repository
public interface RentaRepository extends JpaRepository<Renta, Long> {

}
