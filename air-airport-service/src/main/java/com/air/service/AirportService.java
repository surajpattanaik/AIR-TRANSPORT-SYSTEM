package com.air.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.air.dto.AirportDTO;
import com.air.dto.ScheduleDTO;
import com.air.entity.Airport;
import com.air.exception.bean.ResourceNotFoundException;
import com.air.proxy.BookingFeignClient;
import com.air.proxy.IdGeneratorFeignClient;
import com.air.proxy.ScheduleFeignClient;
import com.air.repository.AirportRepository;
import com.air.utils.AirportMapper;

@Service
public class AirportService {

	@Autowired
	AirportRepository airportRepository;
	
	@Autowired
	IdGeneratorFeignClient idGenerator;
	
	@Autowired
	ScheduleFeignClient sclient;
	
	@Autowired
	BookingFeignClient bclient;
	
	@Autowired
	AirportMapper airportMapper;
	
	public List<AirportDTO> getAllAirports() {
		List<AirportDTO> adtos = airportRepository.findAll()
                .stream()
                .map(airportMapper::toDTO)
                .collect(Collectors.toList());
		//dtos > dto > sclient.get(dto.getId) > dto.setsdto
		adtos.stream().forEach(adto -> adto.setSdto(sclient.getAllSchedulesByAirportId(adto.getId()).getBody()));
		adtos.stream().forEach(adto -> adto.setBdto(bclient.getBookingsByAirportId(adto.getId()).getBody()));
		return adtos;

	}

	public AirportDTO getAirportById(String id) {
	      Airport airport = airportRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Airport not found with id: " + id));
	      AirportDTO adto= airportMapper.toDTO(airport);
	      adto.setSdto(sclient.getAllSchedulesByAirportId(id).getBody());
	      adto.setBdto(bclient.getBookingsByAirportId(id).getBody());
	      
	      return adto;

	}

	public AirportDTO createAirport(AirportDTO airportDTO) {
    	Airport airport = airportMapper.toEntity(airportDTO);
    	airport.setId(idGenerator.getGeneratedId());
        Airport savedAirport = airportRepository.save(airport);
        return airportMapper.toDTO(savedAirport);
	}

	public AirportDTO updateAirport(String id, AirportDTO updatedAirportDTO) {
    	Airport airport = airportRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Airport not found with id: " + id));
        airport.setName(updatedAirportDTO.getName());
        airport.setLocation(updatedAirportDTO.getLocation());
        Airport savedAirport = airportRepository.save(airport);
        return airportMapper.toDTO(savedAirport);
	}

	public void deleteAirport(String id) {
		 Airport airport = airportRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Airport not found with id: " + id));
		 if(!bclient.getBookingsByAirportId(id).getBody().isEmpty()) {
			 bclient.deleteBookingsByAirportId(id);
		 }
		 if(!sclient.getAllSchedulesByAirportId(id).getBody().isEmpty()) {
			 sclient.deleteAllSchedulesByAirportId(id);
		 }
	     airportRepository.delete(airport);
	}

}
