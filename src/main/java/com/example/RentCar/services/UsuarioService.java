package com.example.RentCar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RentCar.dto.Usuario.UsuarioDTO;
import com.example.RentCar.dto.Usuario.UsuarioMapper;
import com.example.RentCar.entities.Usuario;
import com.example.RentCar.repositories.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDTO getUsuarioByCedula(Long id) {
        try {
            return UsuarioMapper.INSTANCE.toDTO(usuarioRepository.findByCedula(id));
        } catch (Exception e) {
            log.error("ERROR consultando el usuario", e);
        }
        return null;
    }

    public UsuarioDTO CreateUsuario(UsuarioDTO usuarioDTO) {
        try {
            if (usuarioDTO.getIdUsuario() != null) {
                throw new IllegalArgumentException("La identificación es generada por la base de datos");
            }
            Usuario usuario = UsuarioMapper.INSTANCE.toEntity(usuarioDTO);
            if (usuario == null) {
                throw new IllegalArgumentException("El usuario no puede ser NULL");
            }
            Usuario usuarioSave = usuarioRepository.save(usuario);
            return UsuarioMapper.INSTANCE.toDTO(usuarioSave);
        } catch (Exception e) {
            log.error("ERROR creando el usuario", e);
        }
        return null;
    }
    
}
