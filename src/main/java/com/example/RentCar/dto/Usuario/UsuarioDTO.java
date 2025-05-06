package com.example.RentCar.dto.Usuario;

import lombok.Data;

@Data
public class UsuarioDTO {
    private Long idUsuario;
    private String nombre;
    private String apellido;
    private Long cedula;
    private String direccion;
    private Long telefono;
}
