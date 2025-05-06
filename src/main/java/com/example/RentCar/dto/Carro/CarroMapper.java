package com.example.RentCar.dto.Carro;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.RentCar.entities.Carro;

@Mapper
public interface CarroMapper {
    CarroMapper INSTANCE = Mappers.getMapper(CarroMapper.class);

    public CarroDTO toDTO(Carro carro);

    public Carro toEntity(CarroDTO carroDTO);
}
