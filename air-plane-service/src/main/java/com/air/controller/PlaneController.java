package com.air.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.air.dto.PlaneDTO;
import com.air.service.PlaneService;

import java.util.List;


@RestController
@RequestMapping("/api/planes")
public class PlaneController {

    
    @Autowired
    private PlaneService planeService;

     // Get all planes
    @GetMapping
    public ResponseEntity<List<PlaneDTO>> getAllPlanes() {
    	List<PlaneDTO> planes = planeService.getAllPlanes();       
        return ResponseEntity.ok(planes);
    }

    // Get plane by ID
    @GetMapping("/{id}")
    public ResponseEntity<PlaneDTO> getPlaneById(@PathVariable String id) {
    	PlaneDTO planeDTO = planeService.getPlaneById(id);
        return ResponseEntity.ok(planeDTO);
    }

    // Create a new plane
    @PostMapping
    public ResponseEntity<PlaneDTO> createPlane(@RequestBody PlaneDTO planeDTO) {
    	PlaneDTO savedPlaneDTO = planeService.createPlane(planeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlaneDTO);
    }

    // Update an existing plane
    @PutMapping("/{id}")
    public ResponseEntity<PlaneDTO> updatePlane(@PathVariable String id, @RequestBody PlaneDTO updatedPlaneDTO) {
    	PlaneDTO savedPlaneDTO = planeService.updatePlane(id,updatedPlaneDTO);
        return ResponseEntity.ok(savedPlaneDTO);
    }

    // Delete an plane
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlane(@PathVariable String id) {
        planeService.deletePlane(id);
        return ResponseEntity.noContent().build();
    }
}
