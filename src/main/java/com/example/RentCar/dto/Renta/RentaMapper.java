package com.example.RentCar.dto.Renta;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.RentCar.entities.Renta;
import com.example.RentCar.repositories.CarroRepository;
import com.example.RentCar.repositories.UsuarioRepository;

@Mapper
public interface RentaMapper {
    RentaMapper INSTANCE = Mappers.getMapper(RentaMapper.class);

    @Mapping(source = "idUsuario.idUsuario", target = "idUsuario")
    @Mapping(source = "idCarro.idCarro", target = "idCarro")
    public RentaDTO toDTO(Renta prestamo);

    default Renta toEntity(RentaDTO prestamoDTO,
            UsuarioRepository usuarioRepository,
            CarroRepository carroRepository) {
        if (prestamoDTO == null) {
            return null;
        }
        Renta prestamo = new Renta();
        Long id = prestamoDTO.getIdUsuario();
        prestamo.setIdUsuario(usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el usuario con esa ID")));
        prestamo.setIdRenta(prestamoDTO.getIdRenta());
        id = prestamoDTO.getIdCarro();
        prestamo.setIdCarro(carroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el carro con esa ID")));
        prestamo.setFechaInicio(prestamoDTO.getFechaInicio());
        prestamo.setFechaFin(prestamoDTO.getFechaFin());
        return prestamo;
    }
}
