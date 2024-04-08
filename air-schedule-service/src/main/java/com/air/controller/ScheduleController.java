package com.air.controller;

import com.air.dto.ScheduleDTO;
import com.air.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    // Get all schedules
    @GetMapping
    public ResponseEntity<List<ScheduleDTO>> getAllSchedules() {
        List<ScheduleDTO> schedules = scheduleService.getAllSchedules();
        return ResponseEntity.ok(schedules);
    }

    // Get schedule by ID
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleDTO> getScheduleById(@PathVariable String id) {
        ScheduleDTO scheduleDTO = scheduleService.getScheduleById(id);
        return ResponseEntity.ok(scheduleDTO);
    }

    // Create a new schedule
    @PostMapping
    public ResponseEntity<ScheduleDTO> createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        ScheduleDTO savedScheduleDTO = scheduleService.createSchedule(scheduleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedScheduleDTO);
    }

    // Update an existing schedule
    @PutMapping("/{id}")
    public ResponseEntity<ScheduleDTO> updateSchedule(@PathVariable String id, @RequestBody ScheduleDTO updatedScheduleDTO) {
        ScheduleDTO savedScheduleDTO = scheduleService.updateSchedule(id, updatedScheduleDTO);
        return ResponseEntity.ok(savedScheduleDTO);
    }

    // Delete a schedule
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable String id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }

    // Get all schedules by airport ID
    @GetMapping("/airport/{id}")
    public ResponseEntity<List<ScheduleDTO>> getAllSchedulesByAirportId(@PathVariable String id) {
        List<ScheduleDTO> schedules = scheduleService.getSchedulesByAirportId(id);
        return ResponseEntity.ok(schedules);
    }

    // Delete all schedules by airport ID
    @DeleteMapping("/airport/{id}")
    public ResponseEntity<Void> deleteAllSchedulesByAirportId(@PathVariable String id) {
        scheduleService.deleteSchedulesByAirportId(id);
        return ResponseEntity.noContent().build();
    }

    // Get all schedules by plane ID
    @GetMapping("/plane/{id}")
    public ResponseEntity<List<ScheduleDTO>> getAllSchedulesByPlaneId(@PathVariable String id) {
        List<ScheduleDTO> schedules = scheduleService.getSchedulesByPlaneId(id);
        return ResponseEntity.ok(schedules);
    }

    // Delete all schedules by plane ID
    @DeleteMapping("/plane/{id}")
    public ResponseEntity<Void> deleteAllSchedulesByPlaneId(@PathVariable String id) {
        scheduleService.deleteSchedulesByPlaneId(id);
        return ResponseEntity.noContent().build();
    }
}
