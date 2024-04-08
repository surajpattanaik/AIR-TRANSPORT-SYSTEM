package com.air.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.air.dto.PlaneDTO;
import com.air.entity.Plane;
import com.air.exception.bean.ResourceNotFoundException;
import com.air.proxy.BookingFeignClient;
import com.air.proxy.IdGeneratorFeignClient;
import com.air.proxy.ScheduleFeignClient;
import com.air.repository.PlaneRepository;
import com.air.utils.PlaneMapper;

@Service
public class PlaneService {

	@Autowired
	PlaneRepository planeRepository;
	
	@Autowired
	IdGeneratorFeignClient idGenerator;
	
	@Autowired
	PlaneMapper planeMapper;
	
	@Autowired
	ScheduleFeignClient sclient;
	
	@Autowired
	BookingFeignClient bclient;
	
	public List<PlaneDTO> getAllPlanes() {
		List<PlaneDTO> pdtos = planeRepository.findAll()
                .stream()
                .map(planeMapper::toDTO)
                .collect(Collectors.toList());
		pdtos.stream().forEach(pdto -> pdto.setSdto(sclient.getAllSchedulesByPlaneId(pdto.getId()).getBody()));
		pdtos.stream().forEach(pdto -> pdto.setBdto(bclient.getBookingsByPlaneId(pdto.getId()).getBody()));
		return pdtos;

	}

	public PlaneDTO getPlaneById(String id) {
	      Plane plane = planeRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Plane not found with id: " + id));
	      PlaneDTO pdto= planeMapper.toDTO(plane);
	      pdto.setSdto(sclient.getAllSchedulesByPlaneId(id).getBody());
	      pdto.setBdto(bclient.getBookingsByPlaneId(id).getBody());
	      
	      return pdto;


	}

	public PlaneDTO createPlane(PlaneDTO planeDTO) {
    	Plane plane = planeMapper.toEntity(planeDTO);
    	plane.setId(idGenerator.getGeneratedId());
        Plane savedPlane = planeRepository.save(plane);
        return planeMapper.toDTO(savedPlane);
	}

	public PlaneDTO updatePlane(String id, PlaneDTO updatedPlaneDTO) {
    	Plane plane = planeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plane not found with id: " + id));
        plane.setName(updatedPlaneDTO.getName());
        plane.setCapacity(updatedPlaneDTO.getCapacity());
        Plane savedPlane = planeRepository.save(plane);
        return planeMapper.toDTO(savedPlane);
	}

	public void deletePlane(String id) {
		 Plane plane = planeRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Plane not found with id: " + id));
		 if(!bclient.getBookingsByPlaneId(id).getBody().isEmpty()) {
			 bclient.deleteBookingsByPlaneId(id);
		 }
		 if(!sclient.getAllSchedulesByPlaneId(id).getBody().isEmpty()) {
			 sclient.deleteAllSchedulesByPlaneId(id);
		 }

		 planeRepository.delete(plane);
	}

}
