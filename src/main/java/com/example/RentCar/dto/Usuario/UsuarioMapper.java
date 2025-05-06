package com.example.RentCar.dto.Usuario;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.RentCar.entities.Usuario;

@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    public UsuarioDTO toDTO(Usuario usuario);

    public Usuario toEntity(UsuarioDTO usuarioDTO);
}
