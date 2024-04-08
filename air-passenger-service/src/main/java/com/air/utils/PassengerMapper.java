package com.air.utils;

import com.air.dto.PassengerDTO;
import com.air.entity.Passenger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PassengerMapper {

    public PassengerDTO toDTO(Passenger passenger) {
        PassengerDTO passengerDTO = new PassengerDTO();
        BeanUtils.copyProperties(passenger, passengerDTO);
        return passengerDTO;
    }

    public Passenger toEntity(PassengerDTO passengerDTO) {
        Passenger passenger = new Passenger();
        BeanUtils.copyProperties(passengerDTO, passenger);
        return passenger;
    }
}
