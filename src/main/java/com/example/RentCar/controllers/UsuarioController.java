package com.example.RentCar.controllers;

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

import com.example.RentCar.dto.Usuario.UsuarioDTO;
import com.example.RentCar.services.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{cedula}")
    public ResponseEntity<HashMap<String, Object>> getUserByCedula(@PathVariable("cedula") Long cedula) {

        HashMap<String, Object> response = new HashMap<>();

        UsuarioDTO usuario = usuarioService.getUsuarioByCedula(cedula);

        if (usuario == null) {
            response.put("error", "Hubo un error buscando el usuario por cedula.");
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }

        response.put("success", usuario);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<HashMap<String, Object>> CreateUser(@RequestBody UsuarioDTO newUser) {

        HashMap<String, Object> response = new HashMap<>();

        UsuarioDTO usuario = usuarioService.CreateUsuario(newUser);

        if (usuario == null) {
            response.put("error", "Hubo un error creando el usuario.");
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }

        response.put("success", usuario);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}