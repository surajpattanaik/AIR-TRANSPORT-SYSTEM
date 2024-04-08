package com.air.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.air.dto.ScheduleDTO;

@FeignClient(name = "schedule-service")
public interface ScheduleFeignClient {

	// Get all schedules by airport ID
    @GetMapping("/api/schedules/airport/{id}")
    public ResponseEntity<List<ScheduleDTO>> getAllSchedulesByAirportId(@PathVariable String id);

    // Delete all schedules by airport ID
    @DeleteMapping("/api/schedules/airport/{id}")
    public ResponseEntity<Void> deleteAllSchedulesByAirportId(@PathVariable String id);


}
