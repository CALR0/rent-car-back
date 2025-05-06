package com.example.RentCar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RentCar.dto.Renta.RentaDTO;
import com.example.RentCar.dto.Renta.RentaMapper;
import com.example.RentCar.entities.Renta;
import com.example.RentCar.repositories.CarroRepository;
import com.example.RentCar.repositories.RentaRepository;
import com.example.RentCar.repositories.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RentaService {

    @Autowired
    private RentaRepository rentaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CarroRepository carroRepository;

    public RentaDTO CreateRenta(RentaDTO rentaDTO) {
        try {
            if (rentaDTO.getIdRenta() != null) {
                throw new IllegalArgumentException("La identificación es generada por la base de datos");
            }
            Renta renta = RentaMapper.INSTANCE.toEntity(rentaDTO, usuarioRepository,
                    carroRepository);
            if (renta == null) {
                throw new IllegalArgumentException("La renta no puede ser NULL");
            }
            Renta rentaGuardada = rentaRepository.save(renta);
            return RentaMapper.INSTANCE.toDTO(rentaGuardada);
        } catch (Exception e) {
            log.error("ERROR creando la renta", e);
        }
        return null;
    }

    public RentaDTO getRentaById(Long id) {
        try {
            if (id == null) {
                throw new IllegalArgumentException("La identificación es generada por la base de datos");
            }
            Renta renta = rentaRepository.findById(id).orElseThrow(
                    () -> new IllegalArgumentException("Prestamo no existente"));
            return RentaMapper.INSTANCE.toDTO(renta);
        } catch (Exception e) {
            log.error("ERROR buscando la renta por el ID", e);
        }
        return null;
    }

    public List<RentaDTO> getAllRentas() {
        try {
            List<Renta> rentas = rentaRepository.findAll();
            return rentas.stream().map(RentaMapper.INSTANCE::toDTO).toList();
        } catch (Exception e) {
            log.error("ERROR buscando todas las rentas", e);
        }
        return List.of();
    }
}
