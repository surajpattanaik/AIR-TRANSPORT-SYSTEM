package com.air.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.air.dto.AirportDTO;
import com.air.service.AirportService;

import java.util.List;


@RestController
@RequestMapping("/api/airports")
public class AirportController {

    
    @Autowired
    private AirportService airportService;

     // Get all airports
    @GetMapping
    public ResponseEntity<List<AirportDTO>> getAllAirports() {
    	List<AirportDTO> airports = airportService.getAllAirports();       
        return ResponseEntity.ok(airports);
    }

    // Get airport by ID
    @GetMapping("/{id}")
    public ResponseEntity<AirportDTO> getAirportById(@PathVariable String id) {
    	AirportDTO airportDTO = airportService.getAirportById(id);
        return ResponseEntity.ok(airportDTO);
    }

    // Create a new airport
    @PostMapping
    public ResponseEntity<AirportDTO> createAirport(@RequestBody AirportDTO airportDTO) {
    	AirportDTO savedAirportDTO = airportService.createAirport(airportDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAirportDTO);
    }

    // Update an existing airport
    @PutMapping("/{id}")
    public ResponseEntity<AirportDTO> updateAirport(@PathVariable String id, @RequestBody AirportDTO updatedAirportDTO) {
    	AirportDTO savedAirportDTO = airportService.updateAirport(id,updatedAirportDTO);
        return ResponseEntity.ok(savedAirportDTO);
    }

    // Delete an airport
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable String id) {
        airportService.deleteAirport(id);
        return ResponseEntity.noContent().build();
    }
}
