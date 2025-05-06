package com.example.RentCar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RentCar.dto.Carro.CarroDTO;
import com.example.RentCar.dto.Carro.CarroMapper;
import com.example.RentCar.entities.Carro;
import com.example.RentCar.repositories.CarroRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public CarroDTO createCarro(CarroDTO carroDTO) {
        try {
            if (carroDTO.getIdCarro() != null) {
                throw new IllegalArgumentException("La identificación es generada por la base de datos");
            }
            Carro carro = CarroMapper.INSTANCE.toEntity(carroDTO);
            if (carro == null) {
                throw new IllegalArgumentException("El carro no puede ser NULL");
            }
            Carro carroSave = carroRepository.save(carro);
            return CarroMapper.INSTANCE.toDTO(carroSave);
        } catch (Exception e) {
            log.error("ERROR creando el carro", e);
        }
        return null;
    }

    public CarroDTO updateCarro(Long id, CarroDTO carroDTO) {
        try {
            if (carroDTO.getIdCarro() == null) {
                throw new IllegalArgumentException("La identificación no puede ser NULL");
            }
            Carro carroFromBD = carroRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Carro no existente"));

            if (carroFromBD.getCiudad().equals(carroDTO.getCiudad()) && carroDTO.getCiudad() != null) {
                carroFromBD.setCiudad(carroFromBD.getCiudad());
            }
            if (carroFromBD.getColor().equals(carroDTO.getColor()) && carroDTO.getColor() != null) {
                carroFromBD.setColor(carroFromBD.getColor());
            }
            if (carroFromBD.getMarca().equals(carroDTO.getMarca()) && carroDTO.getMarca() != null) {
                carroFromBD.setMarca(carroFromBD.getCiudad());
            }
            if (carroFromBD.getModelo().equals(carroDTO.getModelo()) && carroDTO.getModelo() != null) {
                carroFromBD.setModelo(carroFromBD.getCiudad());
            }
            Carro carroSave = carroRepository.save(carroFromBD);
            return CarroMapper.INSTANCE.toDTO(carroSave);
        } catch (Exception e) {
            log.error("ERROR actualizando el carro", e);
        }
        return null;
    }

    public boolean deleteCarro(Long id) {
        try {
            if (id == null) {
                throw new IllegalArgumentException("Id cannot be null");
            }
            carroRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error("ERROR borrando el carro por el ID", e);
        }
        return false;
    }

    
    public CarroDTO getCarroById(Long id) {
        try {
            if (id == null) {
                throw new IllegalArgumentException("Id NO puede ser NULL");
            }
            Carro carro = carroRepository.findById(id).orElse(null);
            return CarroMapper.INSTANCE.toDTO(carro);
        } catch (Exception e) {
            log.error("ERROR obteniendo el carro por el ID", e);
        }
        return null;
    }

    public List<CarroDTO> getAllCarros() {
        try {
            List<Carro> carros = carroRepository.findAll();
            return carros.stream().map(CarroMapper.INSTANCE::toDTO).toList();
        } catch (Exception e) {
            log.error("ERROR obteniendo los carros", e);
        }
        return List.of();
    }
}
