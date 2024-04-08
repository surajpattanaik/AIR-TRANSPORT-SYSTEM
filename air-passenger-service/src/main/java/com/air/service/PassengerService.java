package com.air.service;

import com.air.dto.PassengerDTO;
import com.air.entity.Passenger;
import com.air.exception.bean.ResourceNotFoundException;
import com.air.proxy.BookingFeignClient;
import com.air.proxy.IdGeneratorFeignClient;
import com.air.repository.PassengerRepository;
import com.air.utils.PassengerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private IdGeneratorFeignClient idGenerator;

    @Autowired
    private PassengerMapper passengerMapper;
    
    @Autowired
    private BookingFeignClient bclient;

    public List<PassengerDTO> getAllPassengers() {
    	List<PassengerDTO> pdtos = passengerRepository.findAll()
                .stream()
                .map(passengerMapper::toDTO)
                .collect(Collectors.toList());
		pdtos.stream().forEach(pdto -> pdto.setBdto(bclient.getBookingsByPassengerId(pdto.getId()).getBody()));
		return pdtos;

    }

    public PassengerDTO getPassengerById(String id) {
        Passenger passenger = passengerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Passenger not found with id: " + id));
	      PassengerDTO pdto= passengerMapper.toDTO(passenger);
	      pdto.setBdto(bclient.getBookingsByPassengerId(id).getBody());
	      
	      return pdto;
    }

    public PassengerDTO createPassenger(PassengerDTO passengerDTO) {
        Passenger passenger = passengerMapper.toEntity(passengerDTO);
        passenger.setId(idGenerator.getGeneratedId());
        Passenger savedPassenger = passengerRepository.save(passenger);
        return passengerMapper.toDTO(savedPassenger);
    }

    public PassengerDTO updatePassenger(String id, PassengerDTO updatedPassengerDTO) {
        Passenger passenger = passengerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Passenger not found with id: " + id));
        passenger.setName(updatedPassengerDTO.getName());
        Passenger savedPassenger = passengerRepository.save(passenger);
        return passengerMapper.toDTO(savedPassenger);
    }

    public void deletePassenger(String id) {
        Passenger passenger = passengerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Passenger not found with id: " + id));
		if(!bclient.getBookingsByPassengerId(id).getBody().isEmpty()) {
			 bclient.deleteBookingsByPassengerId(id);
		 }

        passengerRepository.delete(passenger);
    }
}
