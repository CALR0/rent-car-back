package com.example.RentCar.controllers;

import java.time.LocalDate;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.RentCar.dto.Renta.RentaDTO;
import com.example.RentCar.entities.Carro;
import com.example.RentCar.entities.Renta;
import com.example.RentCar.entities.Usuario;
import com.example.RentCar.repositories.CarroRepository;
import com.example.RentCar.repositories.RentaRepository;
import com.example.RentCar.repositories.UsuarioRepository;
import com.example.RentCar.services.RentaService;

@RestController
@RequestMapping("/api/v1/rentas")

public class RentaController {

    @Autowired
    private UsuarioRepository usuarioRepository; // Repositorio para operaciones con Usuario

    @Autowired
    private CarroRepository carroRepository; // Repositorio para operaciones con Carro

    @Autowired
    private RentaRepository rentaRepository; // Repositorio para operaciones con Prestamo

    @Autowired
    private RentaService rentaService;

    @GetMapping("")
    public ResponseEntity<HashMap<String, Object>> getAllRentas() {
        HashMap<String, Object> response = new HashMap<>();

        List<RentaDTO> rentas = rentaService.getAllRentas();
        if (rentas.isEmpty()) {
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }
        response.put("rentas", rentas);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> getRentaById(@PathVariable("id") Long id) {
        HashMap<String, Object> response = new HashMap<>();

        RentaDTO renta = rentaService.getRentaById(id);
        if (renta == null) {
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }
        response.put("renta", renta);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<HashMap<String, Object>> createRenta(@RequestBody RentalFormData formData) {
        HashMap<String, Object> response = new HashMap<>();

        // Buscar el usuario por cédula
        Usuario usuario = usuarioRepository.findByCedula(formData.getCedula());
        if (usuario == null) {
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }

        // Buscar el carro por marca y modelo
        Carro carro = carroRepository.findByMarcaAndModelo(formData.getMarca(), formData.getModelo(), formData.getCiudad());
        if (carro == null) {
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }

        // Calcular la fecha de fin sumando la duración a la fecha de inicio
        LocalDate localFechaInicio = (LocalDate) formData.getFechaInicio();
        LocalDate fechaFin = localFechaInicio.plusDays(formData.getDuracion());

        // Crear el objeto Prestamo con los datos obtenidos
        Renta renta = new Renta();
        renta.setIdUsuario(usuario);
        renta.setIdCarro(carro);
        renta.setFechaInicio(formData.getFechaInicio());
        renta.setFechaFin(fechaFin);
        
        // Guardar el objeto Prestamo en la base de datos
        rentaRepository.save(renta);

        

        response.put("success", renta);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
