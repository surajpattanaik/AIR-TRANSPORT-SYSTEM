package com.air.utils;


import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.air.dto.AirportDTO;
import com.air.entity.Airport;

@Component
public class AirportMapper {

    public  AirportDTO toDTO(Airport airport) {
        AirportDTO airportDTO = new AirportDTO();
        BeanUtils.copyProperties(airport, airportDTO);
        return airportDTO;
    }

    public  Airport toEntity(AirportDTO airportDTO) {
        Airport airport = new Airport();
        BeanUtils.copyProperties(airportDTO, airport);
        return airport;
    }
}
