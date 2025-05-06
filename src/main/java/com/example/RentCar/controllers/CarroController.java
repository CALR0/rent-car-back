package com.example.RentCar.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RentCar.dto.Carro.CarroDTO;
import com.example.RentCar.services.CarroService;

@RestController
@RequestMapping("/api/v1/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping("")
    public ResponseEntity<HashMap<String, Object>> getAllCarros() {

        HashMap<String, Object> response = new HashMap<>();
        List<CarroDTO> carros = carroService.getAllCarros();

        if (carros.isEmpty()) {
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }

        response.put("carros", carros);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}